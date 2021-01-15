package com.example.form.memory;

import lombok.Data;

/**
 * いいね登録用フォーム.
 * 
 * @author masashi.nose
 *
 */
@Data
public class RegisterFavoriteForm {

	/** 思い出ID */
	private String memoryId;
	/** ユーザーID */
	private String userId;

}
