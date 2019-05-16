package com.cs307.sustc.project.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {

    public String check(@Param("account") String account);
}
