package com.cs307.sustc.project.dao;

import com.cs307.sustc.project.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CommentDao {

    Comment queryComment(Integer order_id);

    List<Comment> queryAllComments();

    void insertComment(Comment comment);

    List<Comment> queryComments(Integer user_id);

    List<Map> queryCommentsAndAvatarByID(Integer user_id);
}
