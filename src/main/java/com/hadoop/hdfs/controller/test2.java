package com.hadoop.hdfs.controller;


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
public class test2 {

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    @ResponseBody
    public String mkdir(@RequestParam("path") String path) throws Exception {
        System.out.println(path);
        return path;
    }



}
