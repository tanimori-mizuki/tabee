package com.example.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Destination {
    private Integer id;
    private Integer shioriId;
    private String destination;
    private Integer creatorId;
    private Date createdAt;
    private Integer updaterId;
    private Date updatedAt;
    private Integer version;

    
}