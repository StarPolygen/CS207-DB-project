package com.cs307.sustc.project.dao;

import com.cs307.sustc.project.entity.Favorite;

import java.util.List;

public interface FavoriteDao {

    List<Favorite> queryAllFavorite();

    Favorite queryFavorite(Integer add_user, Integer good_id);

    void insertFavorite(Favorite favorite);

}
