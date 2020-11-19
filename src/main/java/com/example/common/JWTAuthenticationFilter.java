package com.example.common;

import static com.example.common.SecurityConstants.EXPIRATION_TIME;
import static com.example.common.SecurityConstants.HEADER_STRING;
import static com.example.common.SecurityConstants.LOGIN_ID;
import static com.example.common.SecurityConstants.LOGIN_URL;
import static com.example.common.SecurityConstants.PASSWORD;
import static com.example.common.SecurityConstants.SECRET;
import static com.example.common.SecurityConstants.TOKEN_PREFIX;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.form.LoginForm;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 認証フィルター
 * login用のpathでアクセスされた際に、
 * ID/PWを取り出してトークンを発行してresponseヘッダにセットする
 * 
 * @author masashi.nose
 *
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	private static final Logger LOGGER = LoggerFactory.getLogger(JWTAuthenticationFilter.class);
	
	private AuthenticationManager authenticationManager;
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		System.out.println("----------JWTAuthenticationFilterコンストラクタ----------");
		
		this.authenticationManager = authenticationManager;
//		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		
		//ログイン用のパス変更
		setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(LOGIN_URL, "POST"));
	
		//ログイン用のID/PWのパラメータ名を変更する
		setUsernameParameter(LOGIN_ID);
		setPasswordParameter(PASSWORD);
		
		System.out.println("【ログインURL】" + LOGIN_URL);
		System.out.println("【LOGIN ID】" + LOGIN_ID);
		System.out.println("【PASSWORD】" + PASSWORD);
		
	}
	
	/**
	 * 認証の処理
	 *
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException{
		System.out.println("----------JWT認証処理開始----------");
		
		try {
			//requestパラメータからユーザー情報を読み取る
			LoginForm loginForm = new ObjectMapper().readValue(req.getInputStream(), LoginForm.class);
			
			System.out.println("【フォーム】:" + loginForm);
			System.out.println("【username】" + loginForm.getEmail());
			System.out.println("【password】" + loginForm.getPassword());
			
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginForm.getEmail(), loginForm.getPassword(), new ArrayList<>()));
		
		}catch (IOException e) {
			System.out.println("error");
			LOGGER.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 認証に成功した場合の処理
	 *
	 */
	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException, ServletException{
		System.out.println("----------successfulAuthentication called----------");
		String token = Jwts.builder()
						.setSubject(((User)auth.getPrincipal()).getUsername())
						.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
						.signWith(SignatureAlgorithm.HS512, SECRET.getBytes()).claim("role",auth.getAuthorities()).compact();
		
		System.out.println("----------生成されたトークン----------");
		System.out.println(token);
		res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
		
		System.out.println("----------Authorizationヘッダの中身----------");
		System.out.println(res.getHeader("Authorization"));
	}
	

	
}
