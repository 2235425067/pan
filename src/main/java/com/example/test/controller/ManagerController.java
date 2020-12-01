package com.example.test.controller;

import com.example.test.bean.File;
import com.example.test.bean.UserBean;
import com.example.test.bean.message;
import com.example.test.service.FileService;
import com.example.test.service.UserService;
import com.lc.aop.annotation.Log;
import com.lc.aop.entity.SysLog;
import com.lc.aop.service.SysLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@Api(tags = "后台管理")
public class ManagerController {
    @Autowired
    private UserService userService;
    @Autowired
    private SysLogService sysLogService;
    @Autowired
    private FileService fileService;
    @Log("删除用户")
    @PostMapping(value = "/deleteUser")
    @ApiOperation("删除用户")
    @ApiImplicitParam(name = "id", value = "用户id", dataType = "int", required = true)
    @ResponseBody
    public message deleteUser(int id){
        int re= userService.deleteUserBeanById(id);
        message me=new message("删除失败");
        if(re>0) me.setMessage("删除成功");
        return me;
    }
    @Log("添加用户")
    @PostMapping(value = "/addUser")
    @ApiOperation("添加用户")
    @ResponseBody
    public message addUser(UserBean user){
        int re= userService.insertNonEmptyUserBean(user);
        message me=new message("失败");
        if(re>0) me.setMessage("成功");
        return me;
    }
    @Log("修改用户")
    @PostMapping(value = "/updateManager")
    @ApiOperation("修改用户")
    @ResponseBody
    public message updateManager(UserBean user){
        int re= userService.updateNonEmptyUserBeanById(user);
        message me=new message("失败");
        if(re>0) me.setMessage("成功");
        return me;
    }
    @PostMapping(value = "/getLogByPage")
    @ApiOperation("获得用户日志(根据页号和页面大小)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "页号(1开始)",dataType="int",required = true),
            @ApiImplicitParam(name = "pageSize", value = "页面大小",dataType="int",required = true)
    }
    )
    @ResponseBody
    public List<SysLog> updateManager(int currentPage, int pageSize){
        List<SysLog> list= sysLogService.getLogByPage(currentPage,pageSize);
        return list;
    }
    @PostMapping(value = "/getLogCount")
    @ApiOperation("获得用户日志表元组个数")
    @ResponseBody
    public long getLogCount(){
        long ans= sysLogService.getSysLogRowCount();
        return ans;
    }
    @PostMapping(value = "/getCheckFileCount")
    @ApiOperation("获得未审核文件个数")
    @ResponseBody
    public long getCheckFileCount(){
        long ans= fileService.getCheckFileRowCount();
        return ans;
    }
    @PostMapping(value = "/getCheckFileBypage")
    @ApiOperation("获得未审核文件(根据页号和页面大小)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "页号(1开始)",dataType="int",required = true),
            @ApiImplicitParam(name = "pageSize", value = "页面大小",dataType="int",required = true)
    }
    )
    @ResponseBody
    public List<File>  getCheckFileBypage(int currentPage, int pageSize){
        List<File> list= fileService.getCheckFileByPage(currentPage,pageSize);
        return list;
    }
    @Log("修改文件状态")
    @PostMapping(value = "/updateFileState")
    @ApiOperation("修改文件状态")
    @ResponseBody
    public message updateFileState(File file){
        int re= fileService.updateNonEmptyFileById(file);
        message me=new message("失败");
        if(re>0) me.setMessage("成功");
        return me;
    }
}
