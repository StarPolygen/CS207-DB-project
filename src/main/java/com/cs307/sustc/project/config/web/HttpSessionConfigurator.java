package com.cs307.sustc.project.config.web;


import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;
import java.util.List;

/**
 * 从websocket中获取用户session
 * https://www.cnblogs.com/zhuxiaojie/p/6238826.html
 *
 */
public class HttpSessionConfigurator extends Configurator {

    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        HttpSession httpSession = (HttpSession) request.getHttpSession();
        httpSession.setAttribute("recvUserID",request.getHeaders().get("recvUserID").get(0));
        sec.getUserProperties().put(HttpSession.class.getName(), httpSession);
    }
}