package com.example.test.controller;

import com.example.test.bean.*;
import com.example.test.service.*;
import com.hadoop.hdfs.service.HdfsService;
import com.lc.aop.annotation.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@Api(tags = "朋友圈操作")
public class DynamicController {
    @Autowired
    private DynamicService dynamicService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private LikeService likeService;
    @Autowired
    private VideoService videoService;
    @Log("发朋友圈")
    @PostMapping(value = "/addDynamic")
    @ApiOperation("发朋友圈")
    @ResponseBody
    public message addDynamic(Dynamic dynamic,MultipartFile imageFile,MultipartFile videoList) throws Exception {
        int re=0;

        dynamic.setTime(new Date());
        re=dynamicService.insertNonEmptyDynamic(dynamic);
        Image image=new Image();
        image.setDynamicid(dynamic.getId());
        image.setImage(imageFile.getBytes());
        imageService.insertNonEmptyImage(image);
        String path="/panDynamic/"+dynamic.getUsername()+"/"+String.valueOf(dynamic.getId());
        HdfsService.createFile(path,videoList);
        Video video=new Video();
        video.setDynamicid(dynamic.getId());
        video.setFilename(videoList.getOriginalFilename());
        video.setFilepath(path);
        videoService.insertNonEmptyVideo(video);
        message me=new message("失败");
        if (re>0) me.setMessage("成功");
        return me;
    }
    @Log("发朋友圈")
    @PostMapping(value = "/addDynamicTest")
    @ApiOperation("发朋友圈")
    @ResponseBody
    public message addDynamicTest(@RequestParam("content")String content, @RequestParam("username")String username, @RequestParam("file")MultipartFile[] file) throws Exception {
        int re=0;
        Dynamic dynamic=new Dynamic();
        dynamic.setUsername(username);
        dynamic.setContent(content);
        dynamic.setTime(new Date());
        re=dynamicService.insertNonEmptyDynamic(dynamic);
        Image image=new Image();
        MultipartFile imageFile=file[0],videoList=file[1];
        image.setDynamicid(dynamic.getId());
        image.setImage(imageFile.getBytes());
        imageService.insertNonEmptyImage(image);
        String path="/panDynamic/"+dynamic.getUsername()+"/"+String.valueOf(dynamic.getId());
        HdfsService.createFile(path,videoList);
        Video video=new Video();
        video.setDynamicid(dynamic.getId());
        video.setFilename(videoList.getOriginalFilename());
        video.setFilepath(path);
        videoService.insertNonEmptyVideo(video);
        message me=new message("失败");
        if (re>0) me.setMessage("成功");
        return me;
    }
    @Log("发朋友圈")
    @PostMapping(value = "/addDynamicContent")
    @ResponseBody
    public HashMap<String,Object> addDynamicContent(@RequestParam("content")String content, @RequestParam("username")String username, @RequestParam("file")MultipartFile file) throws Exception {
        int re=0;
        Dynamic dynamic=new Dynamic();
        dynamic.setUsername(username);
        dynamic.setContent(content);
        dynamic.setTime(new Date());
        re=dynamicService.insertNonEmptyDynamic(dynamic);
        Image image=new Image();
        image.setDynamicid(dynamic.getId());
        image.setImage(file.getBytes());
        imageService.insertNonEmptyImage(image);
        message me=new message("失败");
        if (re>0) me.setMessage("成功");
        HashMap<String,Object> map=new HashMap<>();
        map.put("id",dynamic.getId());
        return map;
    }
    @PostMapping(value = "/getDynamicBypage")
    @ApiOperation("获得动态(根据页号和页面大小)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "页号(1开始)",dataType="int",required = true),
            @ApiImplicitParam(name = "pageSize", value = "页面大小",dataType="int",required = true)
    }
    )
    @ResponseBody
    public List<HashMap<String,Object>>  getDynamicBypage(int currentPage, int pageSize){
        List<Dynamic> list= dynamicService.getDynamicByPage(currentPage,pageSize);
        List<HashMap<String,Object>> hashMapList=new ArrayList<>();
        for(Dynamic dynamic : list){
            List<Comment> commentList=commentService.selectCommentByDynamicId(dynamic.getId());
            HashMap<String,Object> map1=new HashMap<>();
            map1.put("dynamic",dynamic);
            map1.put("comment",commentList);
            Image image=imageService.selectImageId(dynamic.getId());
            int id=1;
            if(image!=null) id=image.getId();
            map1.put("imageId",id);
            hashMapList.add(map1);
        }
        return hashMapList;
    }
    @Log("发评论")
    @PostMapping(value = "/addComment")
    @ApiOperation("发评论")
    @ResponseBody
    public message addComment(Comment comment) throws Exception {
        int re=0;
        comment.setTime(new Date());
        re=commentService.insertNonEmptyComment(comment);
        message me=new message("失败");
        if (re>0) me.setMessage("成功");
        return me;
    }
    @Log("点赞")
    @PostMapping(value = "/addLike")
    @ApiOperation("点赞")
    @ResponseBody
    public message addLike(Like like) throws Exception {
        int re=0;
        like.setTime(new Date());
        re=likeService.insertNonEmptyLike(like);
        dynamicService.updateLikeNum(like.getDynamicid());
        message me=new message("失败");
        if (re>0) me.setMessage("成功");
        return me;
    }

    @PostMapping(value = "/getDynamicCount")
    @ApiOperation("获得动态个数")
    @ResponseBody
    public long getDynamicCount(){
        long ans= dynamicService.getDynamicRowCount();
        return ans;
    }
    @PostMapping(value = "/getVideoByDynamicId")
    @ApiOperation("获得动态的视频(视频存入HttpServletResponse中)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dynamicId", value = "动态表的id",required = true),
    }
    )
    @ResponseBody
    public String getVideoByDynamicId(HttpServletResponse res,int dynamicId) throws Exception {
        Video video=videoService.selectVideoByDynamicId(dynamicId);
        res.setContentType("video/mp4");
        HdfsService.getDownloadFileStream(res,"hdfs://119.3.167.84:9000"+video.getFilepath()+"/"+video.getFilename());
        return "成功";
    }
    @GetMapping(value = "/getDunamicImage")
    @ResponseBody
    public String getDunamicImage(HttpServletResponse response,int imageId) throws Exception {
        Image image=imageService.selectImageById(imageId);
        response.setContentType("image/*");
        OutputStream out = response.getOutputStream();
        out.write((byte[]) image.getImage());
        //关闭响应输出流
        out.close();
        return "成功";
    }
}
