package com.example.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CORSの設定を行うクラス.
 * 
 * @author masashi.nose
 *
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	@Autowired
	private EnvironmentsConfiguration envConfig;
	
	/**
	 *CORSの許可設定を行うメソッド
	 *環境変数に設定したオリジンのURLを許容
	 *
	 *@param registry CORSの許可一覧
	 *
	 *
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**")
					.allowedHeaders("Access-Control-Allow-Headers",
							"Access-Control-Allow-Origin",
							"Access-Control-Request-Method",
							"Access-Control-Request-Headers",
							"Access-Control-Expose-Headers",
							"Cache-Control",
							"Content-Type",
							"Accept-Language",
			 				"Authorization")
					.allowedMethods("POST", "GET", "OPTIONS")
					.allowedOrigins(envConfig.getOriginUrl());
		}
	
}
