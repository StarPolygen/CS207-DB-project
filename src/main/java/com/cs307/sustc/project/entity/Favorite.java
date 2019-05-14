package com.cs307.sustc.project.entity;

import java.util.Date;

public class Favorite {
    private Integer id;
    private Integer add_user;
    private Integer good_id;
    private Date add_time;

    public Favorite(Integer id, Integer add_user, Integer good_id, Date add_time) {
        this.id = id;
        this.add_user = add_user;
        this.good_id = good_id;
        this.add_time = add_time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdd_user() {
        return add_user;
    }

    public void setAdd_user(Integer add_user) {
        this.add_user = add_user;
    }

    public Integer getgood_id() {
        return good_id;
    }

    public void setgood_id(Integer good_id) {
        this.good_id = good_id;
    }

    public Date getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Date add_time) {
        this.add_time = add_time;
    }
}
