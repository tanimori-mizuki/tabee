package com.example.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Image {
    
	private Integer id;
    private Integer scrapId;
    private String imagePath;
    private Integer creatorId;
    private Date createdAt;

}