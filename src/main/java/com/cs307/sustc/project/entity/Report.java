package com.cs307.sustc.project.entity;

import java.util.Date;

public class Report {
    private Integer id;
    private Integer good_id;
    private Integer reporter_id;
    private String description;
    private String feedback;
    private Date time;

    public Report(Integer id, Integer good_id, Integer reporter_id, String description, String feedback, Date time) {
        this.id = id;
        this.good_id = good_id;
        this.reporter_id = reporter_id;
        this.description = description;
        this.feedback = feedback;
        this.time = time;
    }

    public Report(Integer good_id, Integer reporter_id, String description) {
        this.id = null;
        this.good_id = good_id;
        this.reporter_id = reporter_id;
        this.description = description;
        this.feedback = null;
        this.time = null;
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

    public Integer getReporter_id() {
        return reporter_id;
    }

    public void setReporter_id(Integer reporter_id) {
        this.reporter_id = reporter_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String toString(){
        return "<Report> id: " + id + ", good_id: " + good_id + ", reporter_id: " + reporter_id + ", description: "
                + description + ", feedback: " + feedback + ", time: " + time;
    }
}
