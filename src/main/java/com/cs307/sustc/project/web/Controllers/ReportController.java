package com.cs307.sustc.project.web.Controllers;

import com.cs307.sustc.project.dao.ReportDao;
import com.cs307.sustc.project.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class ReportController {
    @Autowired
    private ReportDao reportDao;

    @CrossOrigin
    @RequestMapping("/report/default")
    public List<Report> getUserInfo(@RequestParam("token") String token){
        if(token==null||(!AdminLoginController.tokens.containsy(token))){
            return new ArrayList<>();
        }
        return reportDao.queryAllReportsWithOutFeedback();
    }

    @CrossOrigin
    @RequestMapping("/report/search")
    public List<Report> findUser(@RequestParam("token") String token,@RequestParam(value = "id") Integer id){
        if(token==null||(!AdminLoginController.tokens.containsy(token))){
            return new ArrayList<>();
        }
        return reportDao.queryAllReportBy(id);
    }

    @RequestMapping(value = "report/send_feedback")
    @CrossOrigin
    public boolean remove(@RequestParam("token") String token,@RequestParam("id") Integer id, @RequestParam("msg") String message) {
        if(token==null||(!AdminLoginController.tokens.containsy(token))){
            return false;
        }
        reportDao.updateFeedback(id,message);
        return true;
    }
}
