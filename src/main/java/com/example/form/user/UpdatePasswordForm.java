package com.example.form.user;

import lombok.Data;

/**
 * ユーザー情報更新用フォーム
 * 
 * @author masashi.nose
 *
 */
@Data
public class UpdatePasswordForm {
	/** ID */
	private String userId;
	/** パスワード */
	private String password;
	/** 確認用パスワード */
	private String confirmPassword;

}
