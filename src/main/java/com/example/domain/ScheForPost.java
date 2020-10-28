package com.example.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ScheForPost {
	
    private Integer id;
    private Integer scheduleId;
    private Integer memoryId;
    private String title;
    private Date startAt;
    private Date finishAt;
    private Date date;
    private Integer iconId;
    private String tel;
    private String destination;
    private String url;
    private String address;
    private String memo;
    private Integer cost;

    
}