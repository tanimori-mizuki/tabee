package com.example.domain;

import java.util.Date;

import lombok.Data;

@Data
public class IndividualCost {
    
	private Integer id;
    private Integer costId;
    private Integer individualUserId;
    private Integer individualCost;
    private Integer creatorId;
    private Date createdAt;
    private Integer updaterId;
    private Date updatedAt;
    private Integer version;

}