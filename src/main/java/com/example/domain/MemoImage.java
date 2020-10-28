package com.example.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MemoImage {
    
	private Integer id;
    private Integer memoId;
    private String imagePath;
    private Integer creatorId;
    private Date createdAt;

   
}