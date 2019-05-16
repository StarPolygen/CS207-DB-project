package com.cs307.sustc.project.web.Controllers;

import com.cs307.sustc.project.dao.ReportDao;
import com.cs307.sustc.project.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ReportController {
    @Autowired
    private ReportDao reportDao;

    @CrossOrigin
    @RequestMapping("/report/default")
    public List<Report> getUserInfo(){
        return reportDao.queryAllReportsWithOutFeedback();
    }

    @CrossOrigin
    @RequestMapping("/report/search")
    public List<Report> findUser(@RequestParam(value = "id") Integer id){
        return reportDao.queryAllReportBy(id);
    }

    @RequestMapping(value = "report/send_feedback")
    @CrossOrigin
    public void remove(@RequestParam("id") Integer id, @RequestParam("msg") String message) {
        reportDao.updateFeedback(id,message);
    }
}
