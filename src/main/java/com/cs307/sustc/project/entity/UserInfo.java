package com.cs307.sustc.project.entity;

import java.util.Date;

public class UserInfo {
    private Integer id;
    private Integer status;
    //0: deny, 1: allow
    private Integer permission;
    private String email_address;
    private String avatar_url;
    private String nickname;
    private String open_id;
    private Date time;


    public UserInfo(Integer id, Integer status, Integer permission, String email_address, String avatar_url, String nickname, String open_id, Date time) {
        this.id = id;
        this.status = status;
        this.permission = permission;
        this.email_address = email_address;
        this.avatar_url = avatar_url;
        this.nickname = nickname;
        this.open_id = open_id;
        this.time = time;
    }


    public UserInfo(Integer status, Integer permission, String email_address, String avatar_url, String nickname, String open_id) {
        this.id = null;
        this.status = status;
        this.permission = permission;
        this.email_address = email_address;
        this.avatar_url = avatar_url;
        this.nickname = nickname;
        this.open_id = open_id;
        this.time = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getnickname() {
        return nickname;
    }

    public void setnickname(String nickname) {
        this.nickname = nickname;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String toString(){
        return "<UserInfo> id: " + id + ", status: " + status + ", permission: " + permission + ", email_address: "
                + email_address + ", avatar_url: " + avatar_url + ", nickname: " + nickname + ", open_id: " + open_id
                + ", time: " + time;
    }
}
