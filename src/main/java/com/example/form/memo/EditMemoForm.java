package com.example.form.memo;

import lombok.Data;

/**
 * メモの編集情報を受け取るフォーム.
 * @author yuri.okada
 *
 */
@Data
public class EditMemoForm {
	/**メモID*/		
	private Integer id;
	/**メモ内容*/
	private String content;
	/**編集可能フラグ*/	
	private Boolean isLocked;
	/**しおりID*/	
	private Integer shioriId;
	/**作成者ID*/		
	private Integer creatorId;
	/**バージョン*/			
	private Integer version;
}

