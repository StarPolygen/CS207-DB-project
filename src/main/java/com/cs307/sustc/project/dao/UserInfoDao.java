package com.cs307.sustc.project.dao;

import com.cs307.sustc.project.entity.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoDao {

    List<UserInfo> queryAllUserInfo();

    /**
     * get a user by id
     * @param id
     * @return
     */
    List<UserInfo> queryUserInfoById(Integer id);

    UserInfo queryUserInfoByOpenID(String open_id);

    UserInfo queryUserInfoByEmailAddress(String email_address);

    void changeStatus(Integer id,Integer val);

    void insertUserInfo(UserInfo userInfo);
}
