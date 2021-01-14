package com.example.common;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * ログイン認証・認可設定クラス.
 * 
 * @author masashi.nose
 *
 */
@Configuration
@EnableWebSecurity(debug=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private EnvironmentsConfiguration envConfig;
	
	 @Override
	 public void configure(HttpSecurity http) throws Exception {
	 	 http
		    .cors()
		    .configurationSource(corsConfigurationSource())
		.and()
			.authorizeRequests().antMatchers("/**").permitAll()
			.anyRequest().authenticated()
		.and()
			.logout()
		.and()
		    .csrf().disable()
		    .addFilter(new JWTAuthenticationFilter(authenticationManager()))
		    .addFilter(new JWTAuthorizationFilter(authenticationManager())).sessionManagement()
		    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		 
		 
//	 	 http	//認可に関する設定
//			.authorizeRequests().antMatchers("/**").permitAll()
//			.anyRequest().authenticated()
//		
//		.and()	//ログインに関する設定
//			.formLogin()	
//			.loginPage("/user_login")	// ログイン画面に遷移させるパス(ログイン認証が必要なパスを指定し、かつログインされていないとこのパスに遷移される)
//			.loginProcessingUrl("/login")	// ログイン可否判定するパス
//			.failureUrl("/user_login?error=true")	// ログイン失敗時に遷移させるパス
//			.defaultSuccessUrl("/", false)	// 第1引数:デフォルトでログイン成功時に遷移させるパス / 第2引数: true :認証後常に第1引数のパスに遷移 | false:認証されてなくて一度ログイン画面に飛ばされてもログインしたら指定したURLに遷移
//			.usernameParameter("email")	// 認証時に使用するユーザ名のリクエストパラメータ名
//			.passwordParameter("password")	// 認証時に使用するパスワードのリクエストパラメータ名
//		
//		.and()	// ログアウトに関する設定
//			.logout()
//			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))	// ログアウトさせる際に遷移させるパス
//			.logoutSuccessUrl("/user_login")	// ログアウト後に遷移させるパス(ここではログイン画面を設定)
//			.deleteCookies("JSESSIONID")	// ログアウト後、Cookieに保存されているセッションIDを削除
//			.invalidateHttpSession(true);	// true:ログアウト後、セッションを無効にする false:セッションを無効にしない
	 }
	 
	 private CorsConfigurationSource corsConfigurationSource() {
		 CorsConfiguration corsConfiguration = new CorsConfiguration();
		 corsConfiguration.addAllowedHeader(corsConfiguration.ALL);
		 corsConfiguration.addAllowedMethod(corsConfiguration.ALL);
		 corsConfiguration.addAllowedOrigin(envConfig.getOriginUrl());
		 corsConfiguration.addAllowedOrigin("http://localhost:8888/ROOT");
		 corsConfiguration.addAllowedOrigin(envConfig.getOriginUrl()+"/**");
		 corsConfiguration.setAllowCredentials(true);
		 
		 //デフォルト以外のヘッダはexposeに設定しないとJS側で読み取れない
		 List<String> exposedHeaderList = new ArrayList<>();
		 exposedHeaderList.add("Authorization");
		 corsConfiguration.setExposedHeaders(exposedHeaderList); 
		 
		 UrlBasedCorsConfigurationSource corsSource = new UrlBasedCorsConfigurationSource();
		 corsSource.registerCorsConfiguration("/**", corsConfiguration);
		 
		 return corsSource;
	 }
	 
	 /**
	  * 「認証」に関する設定. 
	  * 
	  * 認証ユーザを取得する「UserDetailsService」の設定.
	  * パスワード照合時に使う「PasswordEncoder」の設定.
	  * 
	  *  @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
	  * 
	  * @param auth
	  * @throws Exception
	  */
	 @Autowired
	 public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	 }
	 
	 /**
	  * bcryptアルゴリズムでハッシュ化する実装をリターン. 
	  * 
	  * @return bcryptアルゴリズムでハッシュ化する実装オブジェクト
	  */
	 @Bean
	 public BCryptPasswordEncoder bCryptPasswordEncoder() {
		 return new BCryptPasswordEncoder();
	 }
	 
}
