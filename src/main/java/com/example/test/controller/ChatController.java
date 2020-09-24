package com.example.test.controller;

import com.example.test.bean.Friend;
import com.example.test.bean.Friendmessage;
import com.example.test.service.FriendService;
import com.example.test.service.FriendmessageService;
import com.hadoop.hdfs.service.HdfsService;
import com.hadoop.hdfs.service.hbaseService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ChatController {
    @Autowired
    private FriendService friendService;
    @Autowired
    private FriendmessageService friendmessageService;
    @PostMapping("/getmyfriends")
    @ResponseBody
    public HashMap<String,Object> getMyFriends(String name) throws Exception {
        HashMap<String,Object> map=new HashMap<>();
        List<Friend> list=friendService.selectFriendByName(name);
        HashMap<String,String> rl=new HashMap<>();
//        for(Friend friend : list){
//            rl.put("img","https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2987801098,1858423351&fm=26&gp=0.jpg");
//            rl.put("name",friend.getFriendname());
//            rl.put("dept","hello");
//        }
        List<HashMap<String,Object>> l= hbaseService.getFriendList("panUser",list);
        map.put("list",l);
        return map;
    }
    @PostMapping("/listmessagebypage")
    @ResponseBody
    public HashMap<String,Object>  listMessageByPage(@RequestParam Map<String,Object> rmap) throws Exception {
        int currentPage=Integer.parseInt((String)rmap.get("currentPage"));
        int pageSize=Integer.parseInt((String)rmap.get("pageSize"));
        String fromName=(String) rmap.get("fromName");
        String toName=(String) rmap.get("toName");
        HashMap<String,Object> map=new HashMap<>();
        List<HashMap<String,Object>> list=friendmessageService.getAllMessageByPage(currentPage,pageSize,fromName,toName);
        map.put("list",list);
        // map.put("pageCount",pageBean.getPages());
        return map;
    }
    @PostMapping("/insertmessage")
    @ResponseBody
    public HashMap<String,String> insertMessage( Friendmessage friendmessage){
        friendmessageService.insertFriendmessage(friendmessage);
        HashMap<String,String > map=new HashMap<>();
        map.put("state","1");
        return map;
    }
}
