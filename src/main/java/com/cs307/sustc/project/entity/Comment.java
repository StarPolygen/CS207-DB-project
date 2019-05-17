package com.cs307.sustc.project.entity;

import java.util.Date;

public class Comment {
    private Integer id;
    private Integer order_id;
    private Integer rate;
    private String description;
    private Date time;
    private String avatar;

    public Comment(Integer id, Integer order_id, Integer rate, String description, Date time,String avatar) {
        this.id = id;
        this.order_id = order_id;
        this.rate = rate;
        this.description = description;
        this.time = time;
        this.avatar=avatar;
    }


    public Comment(Integer id, Integer order_id, Integer rate, String description, Date time) {
        this.id = id;
        this.order_id = order_id;
        this.rate = rate;
        this.description = description;
        this.time = time;
    }

    public Comment(Integer order_id, Integer rate, String description) {
        this.id = null;
        this.order_id = order_id;
        this.rate = rate;
        this.description = description;
        this.time = null;
    }

    public Integer getId() {
        return id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public Integer getRate() {
        return rate;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public void setDescription(String desc) {
        this.description = description;
    }

    public void setTime(Date time){
        this.time = time;
    }

    public Date getTime(){
        return time;
    }

    public String getAvatar() {
        return avatar;
    }

    public String toString(){
        return "<Comment> id: " + id + ", order_id: " + order_id + ", rate " + rate + ", description: " + description
                + ", time: " + time;
    }
}
