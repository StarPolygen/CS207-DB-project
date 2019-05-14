//package com.cs307.sustc.project.web.Controllers;
//
//import com.cs307.sustc.project.entity.Message;
//import com.cs307.sustc.project.entity.User;
//import com.cs307.sustc.project.service.MessageService;
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import javax.servlet.http.HttpServletRequest;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//
//@RestController
//@RequestMapping("/chat")
//public class MessageController {
//    @Autowired
//    private MessageService messageService;
//
//    @RequestMapping(value = "/messages", method = RequestMethod.GET)
//    private Map<String, Object> messageList(){
//        Map<String, Object> map = new HashMap<>();
//        List<Message> list = messageService.queryMessages();
//        map.put("messageList", list);
//        return map;
//    }
//
//    @RequestMapping(value = "/insertMessage", method = RequestMethod.POST)
//    private Map<String, Object> insertMessage(@RequestBody Message message){
//        System.out.println(message);
//        Map<String, Object> map = new HashMap<>();
//        map.put("success", message);
////        map.put("success", messageService.insertMessage(message));
//        return map;
//    }
//
//    @RequestMapping(value = "/test", method = RequestMethod.GET)
//    private String getMessage(){
//        return "hello";
//    }
//
//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    private String getUserList(HttpServletRequest request){
//        JSONArray jsonArray = new JSONArray();
//        int id_num = Integer.parseInt(request.getSession().getAttribute("userID").toString());
//        for(User user: User.users){
//            if(user.getUserID() != id_num){
//                JSONObject jsonObject = new JSONObject();
//                jsonObject.put("id", user.getUserID());
//                jsonObject.put("nickname", user.getNickName());
//                jsonObject.put("avatar", user.getAvatorUrl());
//                jsonArray.add(jsonObject);
//            }
//        }
//        return jsonArray.toString();
//    }
//}
