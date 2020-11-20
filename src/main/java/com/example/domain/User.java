package com.example.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ユーザ情報のドメイン.
 * @author yuri.okada
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
    /**ユーザID*/
    private Integer id;
    /**ユーザ名*/
    private String name;
    /**メールアドレス*/
    private String email;
    /**パスワード*/
    private String password;
    /**作成日時*/
    private LocalDateTime createdAt;
    /**更新日時*/
    private LocalDateTime updatedAt;
    /**アイコン画像*/
    private String imagePath;
    /**削除フラグ*/
    private Boolean deleted;

   
}