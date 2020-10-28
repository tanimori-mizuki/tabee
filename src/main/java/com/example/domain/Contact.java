package com.example.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Contact {
    
	private Integer id;
    private String name;
    private String email;
    private String content;
    private Date sendAt;

}