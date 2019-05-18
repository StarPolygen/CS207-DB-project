package com.cs307.sustc.project.entity;

import java.util.Date;

public class Good {
    private Integer id;
    private Integer seller_id;
    private Integer good_tag;
    private String name;
    private String description;
    private Date release_time;
    private Integer good_status;// 1: valid, 2: sold; -1: 被下架
    private String picture_url;//default picture url
    private float price;
    private float last_price;

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public Good(Integer id, Integer seller_id, Integer good_tag, String name, String description,
                Date release_time, Integer good_status, float price, float last_price,String picture_url) {
        this.id = id;
        this.seller_id = seller_id;
        this.good_tag = good_tag;
        this.name = name;
        this.description = description;
        this.release_time = release_time;
        this.good_status = good_status;
        this.price = price;
        this.last_price = last_price;
        this.picture_url=picture_url;
    }

    public Good(Integer seller_id, Integer good_tag, String name, String description,
                Integer good_status, float price, float last_price) {
        this.id = null;
        this.seller_id = seller_id;
        this.good_tag = good_tag;
        this.name = name;
        this.description = description;
        this.release_time = null;
        this.good_status = good_status;
        this.price = price;
        this.last_price = last_price;
    }

    public Integer getGood_tag() {
        return good_tag;
    }

    public void setGood_tag(Integer good_tag) {
        this.good_tag = good_tag;
    }

    public Date getRelease_time() {
        return release_time;
    }

    public void setRelease_time(Date release_time) {
        this.release_time = release_time;
    }

    public Integer getGood_status() {
        return good_status;
    }

    public void setGood_status(Integer good_status) {
        this.good_status = good_status;
    }

    public float getLast_price() {
        return last_price;
    }

    public void setLast_price(float last_price) {
        this.last_price = last_price;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(Integer seller_id) {
        this.seller_id = seller_id;
    }

    public Integer getgood_tag() {
        return good_tag;
    }

    public void setgood_tag(Integer good_tag) {
        this.good_tag = good_tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getrelease_time() {
        return release_time;
    }

    public void setrelease_time(Date release_time) {
        this.release_time = release_time;
    }

    public Integer getgood_status() {
        return good_status;
    }

    public void setgood_status(Integer good_status) {
        this.good_status = good_status;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getlast_price() {
        return last_price;
    }

    public void setlast_price(float last_price) {
        this.last_price = last_price;
    }

    public String toString(){
        return "<Good> id: " + id + ", seller_id: " + seller_id + ", good_tag: " + good_tag + ", name: "
                + name + ", description: " + description + ", release_time: " + release_time + ", good_status: "
                + good_status + ", price: " + price + ", last_price: " + last_price;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Good && ((Good) obj).id.equals(id);
    }
}
