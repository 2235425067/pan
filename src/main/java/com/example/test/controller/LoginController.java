package com.example.test.controller;

import com.example.test.bean.UserBean;
import com.example.test.bean.message;
import com.example.test.service.UserService;
import com.hadoop.hdfs.entity.User;
import com.hadoop.hdfs.service.HdfsService;
import com.hadoop.util.Result;
import com.jwt.bean.JwtToken;
import com.jwt.service.RedisService;
import com.jwt.util.JwtUtil;
import com.lc.aop.annotation.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.HandlerMethod;
import java.util.HashMap;
import java.util.UUID;

@Controller
@Api(tags = "用户管理")
public class LoginController {

    //将Service注入Web层
    @Autowired
    UserService userService;
    @Autowired
    private RedisService redisService;
    @RequestMapping("/login")
    public String show(){
        return "login";
    }
    @Log("登录")
    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String login(String name,String password){
        UserBean userBean = userService.loginIn(name,password);
        if(userBean!=null){
            return "success";
        }else {
            return "error";
        }
    }
    @Log("登录")
    @RequestMapping(value = "/loginjson")
    @ResponseBody
    public HashMap<String, String> login1(String name, String password){
        UserBean userBean = userService.loginIn(name,password);
        HashMap<String, String> map=new HashMap<String, String>();
        if(userBean!=null){
            map.put("code","1");
            String userId = UUID.randomUUID().toString();
            // 生成签名
            String token= JwtUtil.sign(userId);
            //String token= userId;
            //redisService.set(token,name);
            map.put("token",token);
        }else {
            map.put("code","0");
        }
        return map;
    }
    @Log("管理员登录")
    @RequestMapping(value = "/ManagerLogin")
    @ResponseBody
    public HashMap<String, String> ManagerLogin(String name, String password){
        UserBean userBean = userService.loginIn(name,password);
        HashMap<String, String> map=new HashMap<String, String>();
        if(userBean!=null&&userBean.getRole().equals("管理员")){
            map.put("code","1");
            String userId = UUID.randomUUID().toString();
            // 生成签名
            String token= JwtUtil.sign(userId);
            //String token= userId;
            //redisService.set(token,name);
            map.put("token",token);
        }else {
            map.put("code","0");
        }
        return map;
    }
    @Log("注册")
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
    @JwtToken
    @Log("获取用户信息")
    @PostMapping(value = "/getUser")
    @ApiOperation("获取用户信息")
    @ApiImplicitParam(name = "name", value = "用户名", defaultValue = "taboo", required = true)
    @ResponseBody
    public UserBean getUser(String name){
        HashMap<String, Object> map=new HashMap<String, Object>();
        UserBean user= userService.getUser(name);
        map.put("user",user);
        return user;
    }
    @Log("更新用户信息")
    @PostMapping(value = "/updateUser")
    @ApiOperation("更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id",dataType="int", required = true),
            @ApiImplicitParam(name = "signature", value = "用户个性签名", defaultValue = "用户暂未填写"),
    }
    )
    @ResponseBody
    public message updateUser(UserBean user){
        int re= userService.updateNonEmptyUserBeanById(user);
        message me=new message("更新失败");
        if(re>0) me.setMessage("更新成功");
        return me;
    }
    @Log("更新用户密码")
    @PostMapping(value = "/updatePassword")
    @ApiOperation("更新用户密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id",dataType="int",required = true),
            @ApiImplicitParam(name = "oldPassword", value = "旧密码", defaultValue = "taboo"),
            @ApiImplicitParam(name = "newPassword", value = "新密码", defaultValue = "taboo"),
    }
    )
    @ResponseBody
    public message updatePassword(int id,String oldPassword,String newPassword){
        UserBean user=userService.selectUserBeanById(id);
        message me=new message("更新失败");
        if(oldPassword.equals(user.getPassword())){
            user.setPassword(newPassword);
            userService.updateNonEmptyUserBeanById(user);
            me.setMessage("更新成功");
        }
        return me;
    }
}
