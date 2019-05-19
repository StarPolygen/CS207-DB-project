package com.cs307.sustc.project.dao;

import com.cs307.sustc.project.entity.Message;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDao {

    List<Message> queryAllMessages();

    List<Message> queryMessages(Integer buyer_id, Integer seller_id, Integer good_id, String send_time);

    void insertMessage(Message chat);

    /**
     * return all
     * @param user_id
     * @return
     */
    List<Message> queryMessageList(Integer user_id);
}
