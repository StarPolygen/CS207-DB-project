package com.cs307.sustc.project.entity;

import java.util.Date;

public class Message {
    private Integer id;
    private Integer buyer_id;
    private Integer seller_id;
    private Integer good_id;
    private Date send_time;
    private Integer type;
    private String content;
    //0: buyer, 1: seller
    private Integer side;

    public Message(Integer id, Integer buyer_id, Integer seller_id, Integer good_id, Date send_time,
                   Integer type, String content, Integer side) {
        this.id = id;
        this.buyer_id = buyer_id;
        this.seller_id = seller_id;
        this.good_id = good_id;
        this.send_time = send_time;
        this.type = type;
        this.content = content;
        this.side = side;
    }

    public Message(Integer buyer_id, Integer seller_id, Integer good_id,
                   Integer type, String content, Integer side) {
        this.id = null;
        this.buyer_id = buyer_id;
        this.seller_id = seller_id;
        this.good_id = good_id;
        this.send_time = null;
        this.type = type;
        this.content = content;
        this.side = side;
    }

    public Integer getid() {
        return id;
    }

    public Integer getside() {
        return side;
    }

    public String getcontent() {
        return content;
    }

    public Integer gettype() {
        return type;
    }

    public Date getSend_time() {
        return send_time;
    }

    public Integer getgood_id() {
        return good_id;
    }

    public Integer getSeller_id() {
        return seller_id;
    }

    public Integer getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(Integer buyer_id) {
        this.buyer_id = buyer_id;
    }

    public void setSeller_id(Integer seller_id) {
        this.seller_id = seller_id;
    }

    public void setgood_id(Integer good_id) {
        this.good_id = good_id;
    }

    public void setSend_time(Date send_time) {
        this.send_time = send_time;
    }

    public void settype(Integer type) {
        this.type = type;
    }

    public void setcontent(String content) {
        this.content = content;
    }

    public void setside(Integer side) {
        this.side = side;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public String toString(){
        return "<Chat> chat_ id: " + id + ", buyer_id: " + buyer_id + ", seller_id: " + seller_id + ", good_id: "
                + good_id + ", send_time: " + send_time + ", type: " + type + ", content: " + content
                + ", side: " + side;
    }
}

