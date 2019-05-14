package com.cs307.sustc.project.dao;

import com.cs307.sustc.project.entity.Report;

import java.util.List;

public interface ReportDao {

    List<Report> queryAllReports();

    void insertReport(Report report);

    void updateFeedback(Integer id, String feedback);
}
