package com.example.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Schedule {
    private Integer id;
    private Integer shioriId;
    private String title;
    private Date startAt;
    private Date finishAt;
    private Date date;
    private Integer iconId;
    private String url;
    private String destination;
    private String address;
    private String tel;
    private String memo;
    private Integer cost;
    private Integer creatorId;
    private Date createdAt;
    private Integer updaterId;
    private Date updatedAt;
    private Integer version;

  
}