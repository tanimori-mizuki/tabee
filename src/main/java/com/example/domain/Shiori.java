package com.example.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Shiori {
    
	private Integer id;
    private String title;
    private Date depAt;
    private Date returnAt;
    private String imagePath;
    private Integer creatorId;
    private Date createdAt;
    private Integer updaterId;
    private Date updatedAt;
    private Integer version;

   
}