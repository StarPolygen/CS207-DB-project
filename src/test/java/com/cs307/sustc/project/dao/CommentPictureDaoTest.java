package com.cs307.sustc.project.dao;

import com.cs307.sustc.project.entity.CommentPicture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentPictureDaoTest {

    @Autowired
    CommentPictureDao commentPictureDao;

    @Test
    public void queryAllCommentPictures(){
        List<CommentPicture> list = commentPictureDao.queryAllCommentPictures();
        for(CommentPicture commentPicture:list)
            System.out.println(commentPicture);
    }

    @Test
    public void queryCommentPicture(){
        List<CommentPicture> list = commentPictureDao.queryCommentPicture(1);
        for(CommentPicture commentPicture:list)
            System.out.println(commentPicture);
    }

    @Test
    public void insertCommentPicture(){
        commentPictureDao.insertCommentPicture(new CommentPicture(1, "https://www.baidu.com"));
    }

}
