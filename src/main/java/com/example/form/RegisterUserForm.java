package com.example.form;

import lombok.Data;

/**
 * 
 * パラメータを受け取るフォーム.
 * 
 * @author masashi.nose
 *
 */
@Data
public class RegisterUserForm {

	/** ユーザー名 */
	private String name;
	/** メールアドレス */
	private String email;
	/** パスワード */
	private String password;
	/** 確認用パスワード */
	private String confirmPassword;

}
