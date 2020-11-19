package com.example.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * メモ画像情報のドメイン.
 * @author yuri.okada
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemoImage {
	
    /**メモ画像ID*/
    private Integer id;
    /**メモID*/
    private Integer memoId;
    /**メモ画像パス*/
    private String imagePath;
    /**作成者ID*/
    private Integer creatorId;
    /**作成日時*/
    private LocalDateTime createdAt;
    /**ユーザ*/
    private User user;

}