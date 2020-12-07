package com.example.form;

import lombok.Data;

/**
 * メールアドレス更新用フォーム
 * 
 * @author masashi.nose
 *
 */
@Data
public class UpdateEmailForm {

	/** ID */
	private String userId;
	/** メールアドレス */
	private String email;
}
