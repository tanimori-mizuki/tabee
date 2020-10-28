package com.example.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Cost {
    private Integer id;
    private Integer shioriId;
    private Integer costCategoryId;
    private Integer cost;
    private Byte isIndividual;
    private String title;
    private Integer payerId;
    private Integer creatorId;
    private Date createdAt;
    private Integer updaterId;
    private Date updatedAt;
    private Integer version;

   
}