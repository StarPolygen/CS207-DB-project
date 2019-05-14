package com.cs307.sustc.project.entity;

public class CommentPicture {
    private Integer id;
    private Integer comment_id;
    private String url;

    public CommentPicture(Integer id, Integer comment_id, String url) {
        this.id = id;
        this.comment_id = comment_id;
        this.url = url;
    }

    public CommentPicture(Integer comment_id, String url) {
        this.id = null;
        this.comment_id = comment_id;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String toString(){
        return "<CommentPicture> id: " + id + ", comment_id: " +comment_id + ", url: " + url;
    }

}
