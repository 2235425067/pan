package com.hadoop.hdfs.controller;

import com.hadoop.hdfs.service.HdfsService;
import com.hadoop.hdfs.service.hbaseService;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.Base64;
import java.util.HashMap;

@RestController
public class hbaseController {
    @RequestMapping(value = "/putImage", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String,String> putImage(@RequestParam("name") String name,@RequestParam("file") MultipartFile file) throws Exception {
        hbaseService.putImage("panUser",name,file.getBytes());
        HashMap<String,String> map=new HashMap<>();
        map.put("state","1");
        map.put("msg","图片上传成功");
        return map;
    }
    @RequestMapping(value = "/getImage", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String,String> getImage(HttpServletResponse res, @RequestParam("name") String name) throws Exception {
        byte[] image=hbaseService.getImage("panUser",name);
        OutputStream outputStream=res.getOutputStream();
        outputStream.write(image);
        HashMap<String,String> map=new HashMap<>();
        map.put("state","1");
        map.put("msg","获得图片成功");
        return map;
    }
    @RequestMapping(value = "/getImageJson", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String,String> getImageJson(HttpServletResponse res, @RequestParam("name") String name) throws Exception {
        byte[] image=hbaseService.getImage("panUser",name);
        String FileBuf = Base64.getEncoder().encodeToString(image);
        HashMap<String,String> map=new HashMap<>();
        map.put("image","data:image/png;base64,"+FileBuf);
        return map;
    }
}
