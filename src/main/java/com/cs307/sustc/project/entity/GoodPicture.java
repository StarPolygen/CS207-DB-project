package com.cs307.sustc.project.entity;

public class GoodPicture {
    private Integer id;
    private Integer good_id;
    private String url;

    public GoodPicture(Integer id, Integer good_id, String url) {
        this.id = id;
        this.good_id = good_id;
        this.url = url;
    }

    public GoodPicture(Integer good_id, String url) {
        this.id = null;
        this.good_id = good_id;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGood_id() {
        return good_id;
    }

    public void setGood_id(Integer good_id) {
        this.good_id = good_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
