package com.example.form.shiori;

import lombok.Data;

/**
 * メンバー削除に必要なデータを受け取るフォーム.
 * @author yuri.okada
 *
 */
@Data
public class DeleteMemberForm {
	
	/**しおりID*/
	private Integer shioriId;
	/**削除対象のユーザID*/	
	private Integer deleteUserId;
	/**しおりの作成者ID*/
	private Integer creatorId;
	/**ログインユーザーID*/
	private Integer loginUserId;

}
