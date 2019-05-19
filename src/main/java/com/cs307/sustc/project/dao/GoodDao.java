package com.cs307.sustc.project.dao;

import com.cs307.sustc.project.entity.Good;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GoodDao {

    List<Good> queryAllGoods();

    List<Integer> queryAllRealGoods();

    List<Integer> queryAllService();

    List<Good> queryByIds(List<Integer> list);

    List<Good> queryGoodsByNumber(String time, Integer number);

    Good queryGoodByID(Integer id);

    Integer insertGood(Good good);

    void changeStatusAdmin(Integer id,Integer val);

    void changeStatus(Integer seller_id, Integer id,Integer val);
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

//    List<Good> queryGoodsRandom();
//
//    List<Good> queryServersRandom();

//    List<Map<String,Object>> queryGoodAndSellerByGoodId(Integer good_id);
    Map<String,Object> queryGoodAndSellerByGoodId(Integer good_id);

    List<Good> queryByKeyStringPriceIncreasing(String keyString, Integer min, Integer max);

    List<Good> queryByKeyStringPriceDecreasing(String keyString, Integer min, Integer max);

    List<Good> queryByKeyStringTimeIncreasing(String keyString,  Integer min, Integer max);

    List<Good> queryByKeyStringTimeDecreasing(String keyString,  Integer min, Integer max);

    List<Good> queryGoodsByUserId(Integer seller_id, Integer status);

    List<Good> queryGoodsByUserId(Integer seller_id);

    void changePrice(Integer seller_id, Integer good_id, Integer price);

    void changeContent(Integer seller_id, Integer id, String name, String description);
}

