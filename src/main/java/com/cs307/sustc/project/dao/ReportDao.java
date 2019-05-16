package com.cs307.sustc.project.dao;

import com.cs307.sustc.project.entity.Report;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportDao {

    List<Report> queryAllReports();

    List<Report> queryAllReportsWithOutFeedback();

    List<Report> queryAllReportsWithFeedback();

    List<Report> queryAllReportBy(Integer id);

    void insertReport(Report report);

    void updateFeedback(Integer id, String feedback);
}
