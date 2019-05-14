package com.cs307.sustc.project.dao;

import com.cs307.sustc.project.entity.Report;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportDaoTest {
    @Autowired
    ReportDao reportDao;

    @Test
    public void queryAllReports(){
        List<Report> list = reportDao.queryAllReports();
        for(Report report : list)
            System.out.println(report);
    }

    @Test
    public void insertReport(){
        reportDao.insertReport(new Report(9, 1, "Good"));
    }

    @Test
    public void updateFeedback(){
        reportDao.updateFeedback(2, "OK");
    }
}
