package com.hadoop.util;

import com.hadoop.hdfs.entity.User;
import org.apache.hadoop.fs.BlockLocation;

import java.util.List;
import java.util.Map;

public class Result {
    private String type,msg;
    private List<Map<String, Object>> list;
    private BlockLocation[] blockLocations;
    private  String targetPath;
    private  byte[] files;
    private User user;
    private  List<Map<String, String>> returnList;
    public static String SUCCESS="succcess";
    public static String FAILURE="succcess";
    public Result(String type, String msg){
        this.type=type;
        this.msg=msg;
    }
    public Result(String type, String msg,List<Map<String, Object>> list){
        this.type=type;
        this.msg=msg;
        this.list=list;
    }
    public Result(String type, String msg,BlockLocation[] blockLocations){
        this.type=type;
        this.msg=msg;
        this.list=list;
        this.blockLocations=blockLocations;
    }
    public Result(String type, String msg,String targetPath){
        this.type=type;
        this.msg=msg;
        this.list=list;
        this.targetPath=targetPath;
    }
    public Result(String type, String msg, byte[] files){
        this.type=type;
        this.msg=msg;
        this.list=list;
        this.files=files;
    }
    public Result(String type, String msg, User user){
        this.type=type;
        this.msg=msg;
        this.list=list;
        this.user=user;
    }
//    public Result(String type, String msg, List<Map<String, String>> returnList){
//        this.type=type;
//        this.msg=msg;
//        this.returnList=returnList;
//    }
}
