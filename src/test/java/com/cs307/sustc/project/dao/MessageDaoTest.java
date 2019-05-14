package com.cs307.sustc.project.dao;

import com.cs307.sustc.project.entity.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageDaoTest {
    @Autowired
    private MessageDao messageDao;

    @Test
    public void queryChat() throws ParseException {
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        Date date = ft.parse("2019-05-13 06:47:03");
        List<Message> chat = messageDao.queryMessages(1, 2, 1, "2019-05-13 19:26:45");
        for(Message c:chat)
            System.out.println(c);
    }

    @Test
    public void queryAllChat(){
        List<Message> list = messageDao.queryAllMessages();
        for(Message me:list)
            System.out.println(me);
    }

    @Test
    public void insertMessage(){
        for(int x = 0; x < 20; x++) {
            Message message = new Message(1, 2, 1, 1, "hello x" + x, 1);
            messageDao.insertMessage(message);
        }
    }

}