package com.example.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 画像ファイルアップロードの設定クラス.
 * @author mizuki.tanimori
 *
 */
@Component
@ConfigurationProperties(prefix = "path")
@Data
public class UploadPathConfiguration {

	private String uploadPath;
	
}
