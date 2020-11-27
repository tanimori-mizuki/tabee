package com.example.domain.shiori;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Destination {
    /**目的地ID*/
    private Integer id;
    /**しおりID*/
    private Integer shioriId;
    /**目的地名D*/
    private String destination;
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

}