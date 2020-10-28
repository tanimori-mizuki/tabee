package com.example.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Message {
    
	private Integer id;
    private Integer userId;
    private Integer shioriId;
    private Date sendAt;
    private String content;
    private String imagePath;

}