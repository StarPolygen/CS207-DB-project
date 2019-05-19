package com.cs307.sustc.project.dao;

import com.cs307.sustc.project.entity.Authentication;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthenticationDao {

    List<Authentication> queryAllAuthentications();

    Authentication queryAuthentication(Integer user_id);

    void deleteAuthentication(Integer id);

    void insertAuthentication(Integer user_id, String code, String email);


}
