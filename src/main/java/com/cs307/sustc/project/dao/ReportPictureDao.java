package com.cs307.sustc.project.dao;

import com.cs307.sustc.project.entity.ReportPicture;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportPictureDao {

    List<ReportPicture> queryAllReportPictures();

    List<ReportPicture> queryReportPicturesByReportID(Integer report_id);

    void insertReportPicture(ReportPicture reportPicture);

}
