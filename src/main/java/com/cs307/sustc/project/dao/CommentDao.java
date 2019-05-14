package com.cs307.sustc.project.dao;

import com.cs307.sustc.project.entity.Comment;

import java.util.List;

public interface CommentDao {

    Comment queryComment(Integer order_id);

    List<Comment> queryAllComments();

    void insertComment(Comment comment);
}
