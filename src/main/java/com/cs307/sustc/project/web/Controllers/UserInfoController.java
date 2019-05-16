package com.cs307.sustc.project.web.Controllers;

import com.cs307.sustc.project.dao.UserInfoDao;
import com.cs307.sustc.project.entity.Report;
import com.cs307.sustc.project.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class UserInfoController {
    @Autowired
    private UserInfoDao userInfoDao;

    @CrossOrigin
    @RequestMapping("/user_info/default")
    public List<UserInfo> getUserInfo(){
        return userInfoDao.queryAllUserInfo();
    }

    @CrossOrigin
    @RequestMapping("/user_info/search")
    public List<UserInfo> findUser(@RequestParam(value = "id") Integer id){
        return userInfoDao.queryUserInfoById(id);
    }

    @RequestMapping(value = "user_info/remove")
    @CrossOrigin
    public String remove(@RequestParam(value = "id", required = false, defaultValue = "-1") Integer id) {
        if(id==-1){
            return "请选择一个用户";
        }
        List<UserInfo> user=userInfoDao.queryUserInfoById(id);
        if(user.size()>0&&user.get(0).getStatus()==1){
//            System.out.println("changed!");
            userInfoDao.changeStatus(id,0);
            return "注销用户成功";
        }
        else{
            return "注销用户失败";
        }
    }
}
