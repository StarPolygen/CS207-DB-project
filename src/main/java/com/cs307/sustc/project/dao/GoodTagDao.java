package com.cs307.sustc.project.dao;

import com.cs307.sustc.project.entity.GoodTag;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodTagDao {

    List<GoodTag> queryAllGoodTags();

    void insertGoodTag(GoodTag goodTag);
}
