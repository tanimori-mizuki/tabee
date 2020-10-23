package com.example.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 環境変数（ymlに設定）を参照するクラス.
 * 
 * 
 * @author masashi.nose
 *
 */
@Component
@ConfigurationProperties(prefix = "environments")
@Data
public class EnvironmentsConfiguration {
	
	/**CORSを許可するオリジンのURL*/
	private String originUrl;

}
