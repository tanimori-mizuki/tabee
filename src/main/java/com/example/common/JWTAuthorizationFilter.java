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
		System.out.println("-----JWT認可処理（doFilterInternalメソッド）-----");
		
		String header = req.getHeader(HEADER_STRING);
		
		System.out.println("【Authorizationヘッダーの中身】" + header);
		
		if(header == null || !header.startsWith(TOKEN_PREFIX)) {
			System.out.println("ヘッダーがnullだよ");
			chain.doFilter(req, res);
			return;
		}
		
		//AuthorizationヘッダのBearer Prefixである場合
		//リクエストからsuthentication認証情報取得
		UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
		System.out.println("【Authentication】" + authentication);
		
		//取得した認証情報をログイン情報としてセット
		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(req, res);
		
	}
	
	/**
	 * リクエストから認証情報取得
	 * 
	 * @param request
	 * @return
	 */
	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request){
		System.out.println("-----getAuthenticationメソッド-----");
		
		String token = request.getHeader(HEADER_STRING);
		System.out.println("【トークン】" + token);
		
		if(token != null) {
			
			try {
				
				//JWTをデコードし、ユーザーのメールアドレス取得
				String userEmail = Jwts.parser()
						.setSigningKey(SECRET.getBytes())
						.parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
						.getBody()
						.getSubject();
				
				System.out.println("【userEmail】" + userEmail);
				
				//JWTをデコードし、claimを取得
				//ClaimとはJSONのkey, valueの一対（例: {"iss":"joe", "exp":1300819380,}）
				Claims claims = Jwts.parser().setSigningKey(SECRET.getBytes())
						.parseClaimsJws(token.replace(TOKEN_PREFIX, "").replace(TOKEN_PREFIX, "").trim()).getBody();
				System.out.println("【claims】" + claims);
				
				//取得したclaimからキー【role】を取得→権限が取得
				List grants = (List) claims.get("role");
				System.out.println("【grantsリスト】" + grants);
				
				String[] arrayRole = new String[grants.size()];
				
				for(int i = 0; i < grants.size(); i++) {
					LinkedHashMap grant = (LinkedHashMap) grants.get(i);
					String roleStr = (String)grant.get("authority");
					arrayRole[i] = roleStr;
					
				}
				
				if(userEmail != null) {
					List<GrantedAuthority> roles = AuthorityUtils.createAuthorityList(arrayRole);
					System.out.println("【roles】" + roles);
					return new UsernamePasswordAuthenticationToken(userEmail, null, roles);
				}
				
				return null;
				
			}catch (ExpiredJwtException e) {
				logger.error("Expired JWT token");
				throw new ExpiredJwtException(e.getHeader(), e.getClaims(), "ログインの有効期限が切れました。ログインをやり直してください。");
			}
		}
		return null;
	}
}
