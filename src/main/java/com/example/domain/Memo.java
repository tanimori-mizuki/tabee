package com.example.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Memo {
    
	private Integer id;
    private String content;
    private Integer shioriId;
    private Byte isLocked;
    private Integer creatorId;
    private Date createdAt;
    private Integer updaterId;
    private Date updatedAt;
    private Integer version;

}