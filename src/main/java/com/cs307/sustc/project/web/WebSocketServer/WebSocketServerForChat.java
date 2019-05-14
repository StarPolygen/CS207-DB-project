//package com.cs307.sustc.project.web.WebSocketServer;
//
//import cn.hutool.log.Log;
//import cn.hutool.log.LogFactory;
//import com.cs307.sustc.project.config.web.HttpSessionConfigurator;
//import net.sf.json.JSONObject;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpSession;
//import javax.websocket.*;
//import javax.websocket.server.ServerEndpoint;
//import java.io.IOException;
//import java.util.Date;
//import java.util.concurrent.ConcurrentHashMap;
//
//import static com.cs307.sustc.project.web.Controllers.LoginController.users_map;
//
///**
// * websocket服务器逻辑
// * 来源：https://blog.csdn.net/moshowgame/article/details/80275084
// */
//
//@ServerEndpoint(value = "/chat/websocket" , configurator = HttpSessionConfigurator.class)
//@Component
//public class WebSocketServerForChat {
//
//    static Log log = LogFactory.get(WebSocketServerForChat.class);
//    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的
//    private static int onlineCount = 0;
//    //concurrent包的线程安全set,用来存放每个客户端对应的MyWebSocket对象
//    private static ConcurrentHashMap<Integer, WebSocketServerForChat> webSocketMap = new ConcurrentHashMap<>();
//    //与某个客户端的连接会话,需要通过它来给客户端发送数据
//    private Session session;
//    private int count = 1;
//    private static int user_count = 0;
//    private int id;
//    private int recv_id;
//
//    /**
//     * 连接成功时调用的方法
//     *
//     */
//    @OnOpen
//    public void onOpen(Session session, EndpointConfig config) {
//        HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
//        if(httpSession.getAttribute("userID") != null){
//            int userID = Integer.parseInt((String)httpSession.getAttribute("userID"));
//            this.session = session;
//            //在线人数加一
//            addOnlineCount();
//            this.id = users_map.get(userID).getUserID();
//            this.recv_id = Integer.parseInt(httpSession.getAttribute("recvUserID").toString());
//            //将会话加入到Map中
//            webSocketMap.put(this.id , this);
//            log.info("有新用户开始监听: " + this.id + ", 当前在线人数为: " + getOnlineCount());
//        }else{
//            //返回登陆
//        }
//    }
//
//    /**
//     * 连接关闭调用的方法
//     *
//     */
//    @OnClose
//    public void onClose(){
//        //将这个连接从Map里面删除
//        webSocketMap.remove(this);
//        //连接数量减1
//        subOnlineCount();
//        log.info("有一连接关闭!当前在线人数为: " + getOnlineCount());
//    }
//
//    /**
//     * 收到客户端消息后调用的方法
//     *
//     * @param message 客户端发送过来的消息*/
//    @OnMessage
//    public void onMessage(String message, Session session) {
//        JSONObject jsonObject = JSONObject.fromObject(message);
//        //接受到窗口sid发送的信息
//        int recvUserID = (int) jsonObject.get("recvUserID");
//        String content = (String) jsonObject.get("content");
//        if(webSocketMap.containsKey(recvUserID)){
//            WebSocketServerForChat instance = webSocketMap.get(recvUserID);
//            if(instance.getRecv_id() == this.id){
//                //向着recvUser窗口发送信息
//                try{
//                    JSONObject js = new JSONObject();
//                    js.put("content", content);
//                    js.put("time", new Date().toString());
//                    this.sendMessage(js.toString());
//                }catch (IOException e){
//                    log.info("web IO异常");
//                }
//            }
//        }
//    }
//
//    /**
//     * 实现服务器主动推送
//     */
//    public void sendMessage(String message) throws IOException {
//        this.session.getBasicRemote().sendText(message);
//    }
//
//    /**
//     *
//     * */
//    public static void sendInfo(String message) throws IOException {
//
//    }
//
//    /**
//     * 发生错误时调用
//     * @param session
//     * @param error
//     */
//    @OnError
//    public void onError(Session session, Throwable error) {
//        log.error("发生错误");
//        error.printStackTrace();
//    }
//
//    // 异步方法
//    public static synchronized int getOnlineCount() {
//        return onlineCount;
//    }
//
//    public static synchronized void addOnlineCount() {
//        WebSocketServerForChat.onlineCount++;
//    }
//
//    public static synchronized void subOnlineCount() {
//        WebSocketServerForChat.onlineCount--;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public int getRecv_id() {
//        return recv_id;
//    }
//}
