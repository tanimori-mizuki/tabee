package com.example.form.shiori;

import java.util.Date;
import java.util.List;


import lombok.Data;

/**
 * しおりの登録情報を受け取るフォーム.
 * @author yuri.okada
 *
 */
@Data
public class RegisterShioriForm {
	
    /**タイトル*/
    private String title;
    /**出発日*/
    private Date depAt;
    /**帰着日*/
    private Date returnAt;
    /**画像名*/
    private String imagePath;
    /**作成者ID*/
    private Integer creatorId;
    /**目的地リスト*/    
    private List<String> destinationList;

}
