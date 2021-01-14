package com.example.form.shiori;

import lombok.Data;

/**
 * メンバーの登録情報を受け取るフォーム.
 * @author yuri.okada
 *
 */
@Data
public class RegisterMemberForm {
	
	/**しおりID*/
	private Integer shioriId;
	/**ユーザID*/
	private Integer loginUserId;

}
