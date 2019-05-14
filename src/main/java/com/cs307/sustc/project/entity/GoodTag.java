package com.cs307.sustc.project.entity;

public class GoodTag {
    private Integer id;
    private String name;

    public GoodTag(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public GoodTag(String name) {
        this.id = null;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "<GoodTag> id: " + id + ", name: " + name;
    }
}
