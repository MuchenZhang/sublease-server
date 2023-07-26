package com.example.sublease.basic.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Data
@Getter
@Setter
public class Post {
    private String id;
    private String apartStyle;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private String city;
    private String location;
    private int rent;
    private int roommate;
    private int pet;
    private String furniture;
    private String remarks;
    private String images;
    private String contact;
    private String createdBy;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    public Post() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() { return this.id; }

    public void setId(String id) { this.id = id; }
}
