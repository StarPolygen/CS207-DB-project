package com.cs307.sustc.project.entity;

public class Authentication {
    private Integer id;
    private Integer user_id;
    private String code;
    private String email;

    public Authentication(Integer user_id, String code, String email) {
        this.id = null;
        this.user_id = user_id;
        this.code = code;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return "<Authentication> id: " + id + ", user_id: " + user_id + ". code: " + code + ", email: " + email;
    }
}
