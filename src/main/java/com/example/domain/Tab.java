package com.example.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Tab {
	
    private Integer id;
    private Integer tabContentId;
    private Integer shioriId;
    private Integer creatorId;
    private Date createdAt;
    private Integer updaterId;
    private Date updatedAt;
    private Integer version;

    
}