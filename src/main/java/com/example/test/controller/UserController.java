package com.example.test.controller;

import com.example.test.bean.File;
import com.example.test.bean.Sharefile;
import com.example.test.bean.message;
import com.example.test.service.SharefileService;
import com.hadoop.hdfs.service.HdfsService;
import com.lc.aop.annotation.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@Api(tags = "用户操作")
public class UserController {
    @Autowired
    private SharefileService sharefileService;
    @Log("分享文件")
    @PostMapping(value = "/shareFile")
    @ApiOperation("分享文件")
    @ResponseBody
    public message shareFile(Sharefile sharefile) throws Exception {
        sharefile.setSharetime(new Date());
        int re=sharefileService.insertNonEmptySharefile(sharefile);
        message me=new message("失败");
        if (re>0) me.setMessage("成功");
        return me;
    }
    @PostMapping(value = "/getShareFileByCode")
    @ApiOperation("根据code获得分享文件")
    @ResponseBody
    public Sharefile getShareFileByCode(Sharefile sharefile) throws Exception {
        Sharefile re=sharefileService.selectSharefileByCode(sharefile.getCode());
        return re;
    }
    @PostMapping(value = "/getShareFileByUsername")
    @ApiOperation("根据用户名获得分享文件")
    @ResponseBody
    public List<Sharefile> getShareFileByUsername(Sharefile sharefile) throws Exception {
        List<Sharefile> re=sharefileService.selectSharefileByUsername(sharefile.getUsername());
        return re;
    }
    @PostMapping(value = "/deleteShareFileById")
    @ApiOperation("取消分享")
    @ResponseBody
    public message deleteShareFileById(Sharefile sharefile) throws Exception {
        sharefile.setSharetime(new Date());
        int re=sharefileService.deleteSharefileById(sharefile.getId());
        message me=new message("失败");
        if (re>0) me.setMessage("成功");
        return me;
    }
}
