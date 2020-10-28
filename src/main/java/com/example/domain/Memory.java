package com.example.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Memory {

	private Integer id;
    private Integer userId;
    private String title;
    private String content;
    private Byte isPublicSche;
    private Date postAt;
   
}