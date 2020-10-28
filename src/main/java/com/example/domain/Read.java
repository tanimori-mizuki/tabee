package com.example.domain;

import lombok.Data;

@Data
public class Read {
    
	private Integer id;
    private Integer userId;
    private Integer messageId;
    private Byte isRead;

   
}