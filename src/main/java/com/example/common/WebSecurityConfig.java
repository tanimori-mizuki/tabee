package com.example.common;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
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
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private EnvironmentsConfiguration envConfig;

	@Autowired
	private UserDetailsService userDetailsService;

	/**
	 * 特定のリクエストに対して「セキュリティ設定」を無視するなど全体にかかわる設定.
	 * 具体的には静的リソースに対してセキュリティの設定を無効にする。
	 * 
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.WebSecurity)
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/img/**", "/lib/**", "/fonts/**");
	}

	/**
	 * 認可の設定.
	 * CORSの設定
	 * ログイン/ログアウトに関する設定.
	 * 
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
				http
					.cors()	//cors有効化の設定
					.configurationSource(corsConfigurationSourceForLogin()) 
				
				.and()	//認可に関する設定
					.authorizeRequests().antMatchers("/**").permitAll()
					.anyRequest().authenticated()
				
				.and()	//ログインに関する設定
					.formLogin()	
					.loginPage("/user_login")	// ログイン画面に遷移させるパス(ログイン認証が必要なパスを指定し、かつログインされていないとこのパスに遷移される)
					.loginProcessingUrl("/login")	// ログイン可否判定するパス
					.failureUrl("/user_login?error=true")	// ログイン失敗時に遷移させるパス
					.defaultSuccessUrl("/", false)	// 第1引数:デフォルトでログイン成功時に遷移させるパス / 第2引数: true :認証後常に第1引数のパスに遷移 | false:認証されてなくて一度ログイン画面に飛ばされてもログインしたら指定したURLに遷移
					.usernameParameter("email")	// 認証時に使用するユーザ名のリクエストパラメータ名
					.passwordParameter("password")	// 認証時に使用するパスワードのリクエストパラメータ名
				
				.and()	// ログアウトに関する設定
					.logout()
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))	// ログアウトさせる際に遷移させるパス
					.logoutSuccessUrl("/user_login")	// ログアウト後に遷移させるパス(ここではログイン画面を設定)
					.deleteCookies("JSESSIONID")	// ログアウト後、Cookieに保存されているセッションIDを削除
					.invalidateHttpSession(true);	// true:ログアウト後、セッションを無効にする false:セッションを無効にしない

	}

	/**
	 * CORS設定
	 * 
	 * @return
	 */
	private CorsConfigurationSource corsConfigurationSourceForLogin() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedHeader(CorsConfiguration.ALL); // HEADERの制限
		corsConfiguration.addAllowedMethod(CorsConfiguration.ALL); // メソッドの制限
		corsConfiguration.addAllowedOrigin("http://localhost:8888/ROOT"); // オリジンの制限
		corsConfiguration.addAllowedOrigin(envConfig.getOriginUrl() + "/**");

		UrlBasedCorsConfigurationSource corsSource = new UrlBasedCorsConfigurationSource();
		corsSource.registerCorsConfiguration("/**", corsConfiguration); // 第1引数：適用されるパス 第2引数：制限内容
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
	 * これを指定することでパスワードハッシュ化やマッチ確認する際に
	 * @Autowired private PasswordEncoder passwordEncoder; 
	 * と記載するとDIされるようになります。
	 * 
	 * @return bcryptアルゴリズムでハッシュ化する実装オブジェクト
	 * 
	 */
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
