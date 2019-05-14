package com.cs307.sustc.project.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailInfo {
    private final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

    private static String smtpServer;//="smtp.sustc.top";
    // SMTP服务器地址
    private static String port;//="465"; // 端口

    private static String fromUserName;//="no-reply@sustc.top";
    // 登录SMTP服务器的用户名,发送人邮箱地址
    private static String fromUserPassword;//="Aa12344321";
    // 登录SMTP服务器的密码

    private String toUser;   // 收件人
    private String subject; // 邮件主题
    private String content; // 邮件正文



    public EmailInfo() {

    }
    public EmailInfo(String toUser, String subject, String content) {
        this.toUser = toUser;
        this.subject = subject;
        this.content = content;
    }

    public String getSSL_FACTORY() {
        return SSL_FACTORY;
    }

    public String getSmtpServer() {
        return smtpServer;
    }

    public String getPort() {
        return port;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public String getFromUserPassword() {
        return fromUserPassword;
    }

    public String getToUser() {
        return toUser;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }
    //get、set方法略
    @Value("${smtpServer}")
    public void setSmtpServer(String smtpServer) {
        this.smtpServer = smtpServer;
    }
    @Value("${smtpport}")
    public void setPort(String port) {
        EmailInfo.port = port;
    }
    @Value("${fromUserName}")
    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }
    @Value("${fromUserPassword}")
    public void setFromUserPassword(String fromUserPassword) {
        this.fromUserPassword = fromUserPassword;
    }
}