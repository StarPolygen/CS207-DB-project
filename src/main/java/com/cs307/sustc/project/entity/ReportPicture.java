package com.cs307.sustc.project.entity;

public class ReportPicture {
    private Integer id;
    private Integer report_id;
    private String url;

    public ReportPicture(Integer id, Integer report_id, String url) {
        this.id = id;
        this.report_id = report_id;
        this.url = url;
    }

    public ReportPicture(Integer report_id, String url) {
        this.id = null;
        this.report_id = report_id;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReport_id() {
        return report_id;
    }

    public void setReport_id(Integer report_id) {
        this.report_id = report_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String toString(){
        return "<ReportPicture> id: " + id + ", report_id: " + report_id + ", url: " + url;
    }
}
