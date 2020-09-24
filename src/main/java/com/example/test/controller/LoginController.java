package com.example.test.controller;

import com.example.test.bean.UserBean;
import com.example.test.service.UserService;
import com.hadoop.hdfs.service.HdfsService;
import com.hadoop.util.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class LoginController {

    //将Service注入Web层
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String show(){
        return "login";
    }

    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String login(String name,String password){
        UserBean userBean = userService.loginIn(name,password);
        if(userBean!=null){
            return "success";
        }else {
            return "error";
        }
    }
    @RequestMapping(value = "/loginjson")
    @ResponseBody
    public HashMap<String, Integer> login1(String name, String password){
        UserBean userBean = userService.loginIn(name,password);
        HashMap<String, Integer> map=new HashMap<String, Integer>();
        if(userBean!=null){
            map.put("code",1);
        }else {
            map.put("code",0);
        }
        return map;
    }
    @RequestMapping(value = "/Rigester")
    @ResponseBody
    public HashMap<String, Integer> Rigester(UserBean user) throws Exception {
        UserBean userBean = userService.chickName(user.getName());
        HashMap<String, Integer> map=new HashMap<String, Integer>();
        if(userBean==null){
            userService.Register(user);
            HdfsService.mkdir("/pan/"+user.getName());
            map.put("code",1);
        }else {
            map.put("code",0);
        }
        return map;
    }


}
