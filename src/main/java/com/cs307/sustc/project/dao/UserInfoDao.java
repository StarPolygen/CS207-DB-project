package com.cs307.sustc.project.dao;

import com.cs307.sustc.project.entity.UserInfo;

import java.util.List;

public interface UserInfoDao {

    List<UserInfo> queryAllUserInfo();

    UserInfo queryUserInfoByOpenID(String open_id);

    UserInfo queryUserInfoByEmailAddress(String email_address);

    void insertUserInfo(UserInfo userInfo);
}
