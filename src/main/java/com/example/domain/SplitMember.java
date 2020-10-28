package com.example.domain;

import java.util.Date;

import lombok.Data;

@Data
public class SplitMember {
    
	private Integer id;
    private Integer costId;
    private Integer individualUserId;
    private Byte isSplit;
    private Byte isPaid;
    private Integer creatorId;
    private Date createdAt;
    private Integer updaterId;
    private Date updatedAt;
    private Integer version;

  
}