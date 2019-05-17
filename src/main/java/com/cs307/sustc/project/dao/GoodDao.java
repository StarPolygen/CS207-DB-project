package com.cs307.sustc.project.dao;

import com.cs307.sustc.project.entity.Good;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodDao {

    List<Good> queryAllGoods();

    List<Good> queryGoodsByNumber(String time, Integer number);

    Good queryGoodByID(Integer id);

    void insertGood(Good good);

    void changeStatus(Integer id,Integer val);
    /**
     * find all goods with a keywords
     * limit 1000
     * @param name
     * @return
     */
    List<Good> findByName(@Param("name") String name);


    /**
     * find all goods that have keyword
     * @param name
     * @return
     */
    List<Good> findByKeyword(@Param("name") String name);

    /**
     * find all goods with a tag
     * @param name
     * @param tag
     * @return
     */
    List<Good> findWithTag(@Param("name") String name,@Param("tag") Integer tag);

    /**
     * find keywords with a tag
     * @param name
     * @param tag
     * @return
     */
    List<Good> findKeywordWithTag(@Param("name") String name,@Param("tag") Integer tag);

    List<Good> queryGoodsRandom();

    List<Good> queryServersRandom();
}
