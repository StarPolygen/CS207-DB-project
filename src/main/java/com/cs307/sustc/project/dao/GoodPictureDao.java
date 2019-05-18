package com.cs307.sustc.project.dao;

import com.cs307.sustc.project.entity.GoodPicture;

import java.util.List;

public interface GoodPictureDao {

    List<GoodPicture> queryAllGoodPictures();

    List<String> queryAllGoodPicturesUrl(Integer good_id);

    List<GoodPicture> queryGoodPicture(Integer good_id);

    void insertGoodPicture(GoodPicture goodPicture);
}
