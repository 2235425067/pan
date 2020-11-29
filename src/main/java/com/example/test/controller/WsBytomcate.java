package com.example.test.controller;

import com.example.test.bean.Friendmessage;
import com.example.test.service.FriendmessageService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@ServerEndpoint(value="/chat/{username}") // 当创建好一个（服务）端点之后，将它以一个指定的URI发布到应用当中，这样远程客户端就能连接上它了
public class WsBytomcate {
    private static List<Session> sessions = new ArrayList<Session>();
    private  static HashMap<String,Session> sessionMap=new HashMap<>();
    private static  FriendmessageService friendmessageService;
    @Autowired
    public void setConfig(FriendmessageService friendmessageService) {
        this.friendmessageService= friendmessageService;
    }
    @OnOpen
    public void OnOpen(Session session, @PathParam(value = "username") String username) {
        sessions.add(session);
        //sendTextMsg("好友 [" + username + "]加入群聊");
        Map<String, String> map = session.getPathParameters();

        sessionMap.put(username,session);
    }
    @OnMessage
    public void OnMsg(String msg,@PathParam(value = "username") String username) {
        JSONObject jo = JSONObject.fromObject(msg);
        String toUsername=jo.getString("toUsername");
        String message=jo.getString("message");
        sendUserMsg( username,toUsername,message);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        Date date = new Date();
        String dateStr = sdf.format(date);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date newDate=null;
        try {
            newDate = df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //friendmessageService.insertFriendmessage(new Friendmessage(1,username,toUsername,message,newDate,0));
    }
    @OnClose
    public void OnClose(Session session, @PathParam("username") String username) throws IOException {
        sessions.remove(session);
        sendTextMsg("好友 ["+ username + "] 退出群聊");
        sessionMap.remove(username);
    }
    @OnError
    public void OnError(Throwable e) {
        e.printStackTrace();
    }
    private void sendTextMsg(String msg) {
        for (Session session : sessions) {
            session.getAsyncRemote().sendText(msg);
        }
    }
    private void sendUserMsg(String username,String toSsername,String msg) {
        if(sessionMap==null) sessionMap=new HashMap<>();
        if(sessionMap.containsKey(toSsername)==false){
            return ;
        }
        Session session=sessionMap.get(toSsername);
        String ans="{'userName':'"+username+"','message':'"+msg+"'}";
        session.getAsyncRemote().sendText(ans);
    }
}