package com.example.form.shiori;

import java.util.Date;
import java.util.List;

import com.example.domain.shiori.Destination;

import lombok.Data;

/**
 * しおりの編集情報を受け取るフォーム.
 * @author yuri.okada
 *
 */
@Data
public class EditShioriForm {
    /**しおりID*/
	private Integer id;
    /**タイトル*/
    private String title;
    /**出発日*/
    private Date depAt;
    /**帰着日*/
    private Date returnAt;
    /**作成者ID*/
    private Integer creatorId;
    /**登録済目的地リスト*/    
    private List <Destination> registerdDestinationList;
    /**入力された目的地リスト*/    
    private List<String> destinationList;
    /**目的地IDリスト*/
    private List<Integer> destinationIdList;
    /**バージョン*/        
    private Integer version;

}
