package com.cs307.sustc.project.entity;

import java.util.Date;

public class Order {
    private Integer id;
    private Integer buyer_id;
    private Integer good_id;
    private Date time;
    private Integer status;

    public Order(Integer id, Integer buyer_id, Integer good_id, Date time, Integer status) {
        this.id = id;
        this.buyer_id = buyer_id;
        this.good_id = good_id;
        this.time = time;
        this.status = status;
    }

    public Order(Integer buyer_id, Integer good_id, Integer status) {
        this.id = null;
        this.buyer_id = buyer_id;
        this.good_id = good_id;
        this.time = null;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(Integer buyer_id) {
        this.buyer_id = buyer_id;
    }

    public Integer getGood_id() {
        return good_id;
    }

    public void setGood_id(Integer good_id) {
        this.good_id = good_id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String toString(){
        return "<Order> id: " + id + ", buyer_id: " + buyer_id + ", good_id: " + good_id + ", time: " + time
                + ", status: " + status;
    }
}
