package com.lc.aop.entity;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class SysLog {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "操作方法描述")
    private String operation;
    @ApiModelProperty(value = "运行时间")
    private Object time;
    @ApiModelProperty(value = "操作方法")
    private String method;
    @ApiModelProperty(value = "请求参数")
    private String params;
    @ApiModelProperty(value = "ip")
    private String ip;
    @ApiModelProperty(value = "请求时间")
    private Date createTime;
    public SysLog() {
        super();
    }
    public SysLog(Integer id,String username,String operation,Object time,String method,String params,String ip,java.util.Date createTime) {
        super();
        this.id = id;
        this.username = username;
        this.operation = operation;
        this.time = time;
        this.method = method;
        this.params = params;
        this.ip = ip;
        this.createTime = createTime;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOperation() {
        return this.operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Object getTime() {
        return this.time;
    }

    public void setTime(Object time) {
        this.time = time;
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return this.params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

}
