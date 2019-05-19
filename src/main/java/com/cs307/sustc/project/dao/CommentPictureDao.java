package com.cs307.sustc.project.dao;

import com.cs307.sustc.project.entity.CommentPicture;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentPictureDao {

    List<CommentPicture> queryAllCommentPictures();

    List<CommentPicture> queryCommentPicture(Integer comment_id);

    void insertCommentPicture(CommentPicture commentPicture);
}
