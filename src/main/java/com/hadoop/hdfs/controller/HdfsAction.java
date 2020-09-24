package com.hadoop.hdfs.controller;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.test.bean.UserBean;
import com.hadoop.hdfs.service.WordCount;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.fs.BlockLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.hadoop.hdfs.entity.User;
import com.hadoop.hdfs.service.HdfsService;
import com.hadoop.util.Result;

import javax.servlet.http.HttpServletResponse;

@RestController
public class HdfsAction {

    private static Logger LOGGER = LoggerFactory.getLogger(HdfsAction.class);

    /**
     * 创建文件夹
     * @param path
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/mkdir", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String,String> mkdir(@RequestParam("path") String path) throws Exception {
        HashMap<String,String> map=new HashMap<>();
        if (StringUtils.isEmpty(path)) {
            LOGGER.debug("请求参数为空");
            map.put("state","0");
            map.put("msg","请求参数为空");
        }
        // 创建空文件夹
        boolean isOk = HdfsService.mkdir(path);
        if (isOk) {
            LOGGER.debug("文件夹创建成功");
            map.put("state","1");
            map.put("msg","文件夹创建成功");
        } else {
            LOGGER.debug("文件夹创建失败");
            map.put("state","0");
            map.put("msg","文件夹创建失败");
        }
        return map;
    }
    @PostMapping("/listFile")
    public HashMap<String,Object>  listFile(@RequestParam("path") String path) throws Exception {
        HashMap<String,Object> map=new HashMap<>();
        if (StringUtils.isEmpty(path)) {
            map.put("state","0");
            map.put("msg","请求参数为空");
            return map;
        }
        List<Map<String, String>> returnList = HdfsService.listFile(path);
        map.put("list",returnList);
        return map;
    }
    @PostMapping("/listFilebypage")
    public HashMap<String,Object>  listFilebypage(@RequestParam Map<String,Object> rmap) throws Exception {
        int currentPage=Integer.parseInt((String)rmap.get("currentPage"));
        int pageSize=Integer.parseInt((String)rmap.get("pageSize"));
        String path=(String) rmap.get("path");
        HashMap<String,Object> map=new HashMap<>();
        if (StringUtils.isEmpty(path)) {
            map.put("state","0");
            map.put("msg","请求参数为空");
            return map;
        }
        List<Map<String, String>> returnList = HdfsService.listFile(path);
        int len=returnList.size();
        map.put("rowCount",returnList.size());
        returnList=returnList.subList(currentPage*pageSize-pageSize,Math.min(currentPage*pageSize,len));
        map.put("list",returnList);
        map.put("pageSize",pageSize);
       // map.put("pageCount",pageBean.getPages());
        return map;
    }

    @PostMapping("/createFile")
    public HashMap<String,Object> createFile(@RequestParam("path") String path  ,@RequestParam("file") MultipartFile file)
            throws Exception {
        //String path="/pan/taboo";
        HashMap<String,Object> map=new HashMap<>();
        if (StringUtils.isEmpty(path) || null == file.getBytes()) {
            map.put("state","0");
            map.put("msg","请求参数为空");
            return map;
        }
        HdfsService.createFile(path, file);
        map.put("state","1");
        map.put("msg","创建文件成功");
        return map;
    }

    @GetMapping("/downloadFile")
    public HashMap<String,Object> downloadFile(@RequestParam("path") String path, @RequestParam("downloadPath") String downloadPath)
            throws Exception {
        path="C:\\Users\\ASUS\\Desktop\\test.txt";
        downloadPath="hdfs://119.3.167.84:9000/test.txt";
        HdfsService.downloadFile(path, downloadPath);
        HashMap<String,Object> map=new HashMap<>();
        map.put("state","1");
        map.put("msg","下载文件成功");
        return map;
    }
    @PostMapping("/deleteFile")
    public HashMap<String,Object>  deleteFile(@RequestParam("list")List<String>list) throws Exception {
        for(String path:list){
            boolean isOk = HdfsService.deleteFile(path);
        }
        HashMap<String,Object> map=new HashMap<>();
        map.put("state","1");
        map.put("msg","delete file success");
        return map;
    }
    @PostMapping(value = "/downLoad")
    @ResponseBody
    public String downLoad(HttpServletResponse res,@RequestParam("filePath") String filePath) throws Exception {

        res.setHeader("Content-type", "text/html;charset=UTF-8");

        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=UTF-8");
        HdfsService.getDownloadFileStream(res,filePath);
        return "success";
    }
    @RequestMapping(value = "/downLoadMovie")
    @ResponseBody
    public String downLoadMovie(HttpServletResponse res,@RequestParam("filePath") String filePath) throws Exception {
        res.setContentType("video/mp4");
        HdfsService.getDownloadFileStream(res,filePath);
        return "success";
    }
    @PostMapping(value = "/readfile")
    @ResponseBody
    public HashMap<String,Object> readFile(HttpServletResponse res,@RequestParam("filePath") String filePath) throws Exception {

        res.setHeader("Content-type", "text/html;charset=UTF-8");

        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=UTF-8");
        List<String> list=HdfsService.readFile(res,filePath);
        HashMap<String,Object> map=new HashMap<>();
        map.put("list",list);
        return map;
    }
    @GetMapping(value = "/downLoadTest")
    @ResponseBody
    public String downLoadTest(HttpServletResponse res,@RequestParam("filePath") String filePath) throws Exception {
        filePath="hdfs://119.3.167.84:9000/pan/taboo/06-高精度问题.pptx";
        res.setHeader("Content-Disposition", "attachment; filename=1.pptx");
        HdfsService.getDownloadFileStream(res,filePath);
        return "success";
    }
    @PostMapping(value = "/wordcount")
    @ResponseBody
    public HashMap<String,Object> wordCount(@RequestParam("filePath") String filePath,String name,String fileName) throws Exception {
        WordCount.solveWordCount(filePath,name,fileName);
        HashMap<String,Object> map=new HashMap<>();
        map.put("state",1);
        map.put("message","word cound success!");
        return map;
    }
    @PostMapping(value = "/test")
    @ResponseBody
    public String test(@RequestParam("path") String path) throws Exception {
        return path;
    }
}