package com.cs307.sustc.project.dao;

import com.cs307.sustc.project.entity.GoodTag;

import java.util.List;

public interface GoodTagDao {

    List<GoodTag> queryAllGoodTags();

    void insertGoodTag(GoodTag goodTag);
}
