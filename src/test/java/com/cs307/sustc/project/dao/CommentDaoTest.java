package com.cs307.sustc.project.dao;

import com.cs307.sustc.project.entity.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentDaoTest {
    @Autowired
    private CommentDao commentDao;

    @Test
    public void queryComment(){
        System.out.println(commentDao.queryComment(1));
    }

    @Test
    public void queryAllComments(){
        List<Comment> list = commentDao.queryAllComments();
        for(Comment comment:list)
            System.out.println(comment);
    }

    @Test
    public void insertComment(){
        commentDao.insertComment(new Comment(3, 5,"good x"));
    }

    @Test
    public void queryCommentsTest(){
        System.out.println(commentDao.queryComments(1));
    }
}
