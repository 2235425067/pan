package com.example.test.bean;

import io.swagger.annotations.ApiModelProperty;

public class File {
    @ApiModelProperty(value = "id",dataType="int")
    private Integer id;
    @ApiModelProperty(value = "文件名")
    private String filename;
    @ApiModelProperty(value = "文件路径")
    private String filepath;
    @ApiModelProperty(value = "用户id",dataType = "Date")
    private java.util.Date time;
    @ApiModelProperty(value = "文件大小",dataType="int")
    private Integer len;
    @ApiModelProperty(value = "文件状态（0为未审核 1为审核通过 2为审核未通过）",dataType="int")
    private Integer state;
    public File() {
        super();
    }
    public File(Integer id,String filename,String filepath,java.util.Date time,Integer len,Integer state) {
        super();
        this.id = id;
        this.filename = filename;
        this.filepath = filepath;
        this.time = time;
        this.len = len;
        this.state = state;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return this.filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public java.util.Date getTime() {
        return this.time;
    }

    public void setTime(java.util.Date time) {
        this.time = time;
    }

    public Integer getLen() {
        return this.len;
    }

    public void setLen(Integer len) {
        this.len = len;
    }

    public Integer getState() {
        return this.state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}
