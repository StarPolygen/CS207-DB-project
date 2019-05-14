package com.cs307.sustc.project.dao;

import com.cs307.sustc.project.entity.ReportPicture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportPictureDaoTest {
    @Autowired
    ReportPictureDao reportPictureDao;

    @Test
    public void queryAllReportPictures(){
        List<ReportPicture> list = reportPictureDao.queryAllReportPictures();
        for(ReportPicture reportPicture : list)
            System.out.println(reportPicture);
    }

    @Test
    public void queryReportPicturesByReportID(){
        List<ReportPicture> list = reportPictureDao.queryReportPicturesByReportID(2);
        for(ReportPicture reportPicture : list)
            System.out.println(reportPicture);
    }

    @Test
    public void insertReportPicture(){
        reportPictureDao.insertReportPicture(new ReportPicture(2, "https://www"));
    }
}
