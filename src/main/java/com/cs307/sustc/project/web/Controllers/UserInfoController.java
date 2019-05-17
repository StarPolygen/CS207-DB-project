package com.cs307.sustc.project.web.Controllers;

import com.cs307.sustc.project.dao.CommentDao;
import com.cs307.sustc.project.dao.UserInfoDao;
import com.cs307.sustc.project.entity.Comment;
import com.cs307.sustc.project.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class UserInfoController {
    @Autowired
    private UserInfoDao userInfoDao;

    @CrossOrigin
    @RequestMapping("/user_info/default")
    public List<UserInfo> getUserInfo(@RequestParam("token") String token){
        if(token==null||(!AdminLoginController.tokens.containsy(token))){
            return new ArrayList<>();
        }
        return userInfoDao.queryAllUserInfo();
    }

    @CrossOrigin
    @RequestMapping("/user_info/search")
    public List<UserInfo> findUser(@RequestParam(value = "id") Integer id){
        return userInfoDao.queryUserInfoById(id);
    }

    @RequestMapping(value = "user_info/remove")
    @CrossOrigin
    public String remove(@RequestParam("token")String token, @RequestParam(value = "id", required = false, defaultValue = "-1") Integer id) {
        if(token==null||(!AdminLoginController.tokens.containsy(token))){
            return "登录信息错误，操作失败";
        }
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


    /**
     * just test
     * @return
     */
    @Autowired
    private CommentDao commentDao;
    @RequestMapping(value = "user_info/comments")
    @CrossOrigin
    public List<Comment> getComments(){
        return commentDao.queryComments(1);
    }
}
