package com.example.domain;

import java.util.Date;

import lombok.Data;

@Data
public class CheckItem {
    
	private Integer id;
    private String checkTitle;
    private Integer categoryId;
    private Integer tabId;
    private Byte isShared;
    private Integer creatorId;
    private Date createdAt;
    private Integer updaterId;
    private Date updatedAt;
    private Byte isChecked;
    private Integer version;

}