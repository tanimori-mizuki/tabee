package com.example.form.memo;

import lombok.Data;

@Data
public class RegisterMemoForm {
	
	/**メモ内容*/
	private String content;
	/**編集可能フラグ*/	
	private Boolean isLocked;
	/**しおりID*/	
	private Integer shioriId;
	/**作成者ID*/		
	private Integer creatorId;	

}
