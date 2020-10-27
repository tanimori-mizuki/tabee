package com.example.common;

import static com.example.common.SecurityConstants.EXPIRATION_TIME;
import static com.example.common.SecurityConstants.HEADER_STRING;
import static com.example.common.SecurityConstants.LOGIN_ID;
import static com.example.common.SecurityConstants.LOGIN_URL;
import static com.example.common.SecurityConstants.PASSWORD;
import static com.example.common.SecurityConstants.SECRET_KEY;
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
 * JWT(JSON Web Token)を使用した認証フィルター.
 * 
 * login用のパスでアクセスされた際に、IDとパスワードを取り出しtokenを発行、responseヘッダにセット.
 * 
 * @author masashi.nose
 *
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	private static final Logger lOGGER = LoggerFactory.getLogger(JWTAuthenticationFilter.class);
	
	private AuthenticationManager authenticationManager;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//コンストラクタ
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.authenticationManager = authenticationManager;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		
		//ログイン用のパスを変更
		setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(LOGIN_URL, "POST"));
		
		//ログイン用のID・PWのパラメータ名を変更
		setUsernameParameter(LOGIN_ID);
		setPasswordParameter(PASSWORD);
	}
	
	/**
	 * 認証処理
	 * 
	 * @param req リクエスト
	 * @param res　レスポンス
	 * @return　認証情報
	 * @throws AuthenticationException
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException{
		try {
			//requestパラメータからユーザー情報を読み取る
			LoginForm loginForm = new ObjectMapper().readValue(req.getInputStream(), LoginForm.class);
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginForm.getEmail(), loginForm.getPassword(), new ArrayList<>()));
			
			
		}catch (IOException e) {
			lOGGER.error(e.getMessage());
			throw new RuntimeException(e);
		}
		
		
	}
	
	/**
	 * 認証に成功した場合の処理
	 *
	 */
	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException, ServletException{
		
		//loginIdからtokenを設定してヘッダにセットする.
		String token = Jwts.builder().setSubject(((User)auth.getPrincipal()).getUsername())
						.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
						.signWith(SignatureAlgorithm.HS512, SECRET_KEY.getBytes()).claim("role", auth.getAuthorities()).compact();
		
		res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
		
		
	}
}
