package com.example.form;

import lombok.Data;

/**
 * パスワード変更時のメールアドレスチェック用フォーム
 * 
 * @author masashi.nose
 *
 */
@Data
public class CheckEmailForm {

	/** メールアドレス */
	private String email;

}
