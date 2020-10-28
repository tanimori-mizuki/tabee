package com.example.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Category {
  
    private Integer id;
    private Integer tabId;
    private Integer creatorId;
    private Date createdAt;
    private Integer updaterId;
    private Date updatedAt;
    private Integer version;
    private Integer categoryContentId;

   
   
}