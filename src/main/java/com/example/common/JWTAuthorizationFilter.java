package com.example.common;

import static com.example.common.SecurityConstants.HEADER_STRING;
import static com.example.common.SecurityConstants.SECRET;
import static com.example.common.SecurityConstants.TOKEN_PREFIX;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;

/**
 * 認可フィルター（リクエストにAuthorizationヘッダがあった場合はToken検証）.
 * Token検証＋Tokenから情報を取得する.
 * 
 * @author masashi.nose
 *
 */
public class JWTAuthorizationFilter extends BasicAuthenticationFilter{

	 private AuthenticationManager authenticationManager;
	
	public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException{
		String header = req.getHeader(HEADER_STRING);
		Enumeration<String> headers = req.getHeaderNames();
		
		System.out.println("ヘッダーの中身");
		System.out.println(header);
		System.out.println(headers);
		
		if(header == null || !header.startsWith(TOKEN_PREFIX)) {
			chain.doFilter(req, res);
			return;
		}
		
		//AuthorizationヘッダのBearer Prefixである場合
		UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(req, res);
		
	}
	
	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request){
		String token = request.getHeader(HEADER_STRING);
		System.out.println(token);
		
		if(token != null) {
			
//			try {
				
				//どのような権限を持っているか調べる
				String user = Jwts.parser()
						.setSigningKey(SECRET.getBytes())
						.parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
						.getBody()
						.getSubject();
				
				System.out.println("権限調べた結果");
				System.out.println(user);
				
				Claims claims = Jwts.parser().setSigningKey(SECRET.getBytes())
						.parseClaimsJws(token.replace(TOKEN_PREFIX, "").replace(TOKEN_PREFIX, "").trim()).getBody();
				
				System.out.println("claims");
				System.out.println(claims);
				
				List grants = (List) claims.get("role");
				System.out.println(grants);
				
				String[] arrayRole = new String[grants.size()];
				
				for(int i = 0; i < grants.size(); i++) {
					LinkedHashMap grant = (LinkedHashMap) grants.get(i);
					String roleStr = (String)grant.get("authority");
					arrayRole[i] = roleStr;
					
				}
				
				if(user != null) {
					List<GrantedAuthority> roles = AuthorityUtils.createAuthorityList(arrayRole);
					return new UsernamePasswordAuthenticationToken(user, null, roles);
				}
				
				return null;
				
//			}catch (ExpiredJwtException e) {
//				logger.error("Expired JWT token");
//				throw new ExpiredJwtException(e.getHeader(), e.getClaims(), "ログインの有効期限が切れました。ログインをやり直してください。");
//			}
		}
		return null;
	}
}
