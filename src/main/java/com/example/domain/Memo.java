package com.example.domain;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * メモ情報のドメイン.
 * @author yuri.okada
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Memo {

    /**メモID*/
    private Integer id;
    /**メモ内容*/
    private String content;
    /**しおりID*/
    private Integer shioriId;
    /**メモID*/
    private Boolean isLocked;
    /**作成者ID*/
    private Integer creatorId;
    /**作成日時*/
    private LocalDateTime createdAt;
    /**更新者ID*/
    private Integer updaterId;
    /**更新日時*/
    private LocalDateTime updatedAt;
    /**バージョン*/
    private Integer version;
    /**ユーザ*/
    private User user;
    /**メモ画像リスト*/
    private List<MemoImage> memoImageList;
  
}