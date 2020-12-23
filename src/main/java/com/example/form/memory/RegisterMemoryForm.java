package com.example.form.memory;

import lombok.Data;

/**
 * 思い出投稿用フォーム.
 * 
 * @author masashi.nose
 *
 */
@Data
public class RegisterMemoryForm {

	/** ユーザーID */
	private String userId;
	/** しおりID */
	private String shioriId;
	/** タイトル */
	private String title;
	/** 内容 */
	private String content;
	/** スケジュール表示 */
	private Boolean isPublicSche;

}
