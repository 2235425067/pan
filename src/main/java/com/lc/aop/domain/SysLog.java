package com.lc.aop.domain;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class SysLog implements Serializable {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "操作方法描述")
    private String operation;
    @ApiModelProperty(value = "运行时间")
    private Integer time;
    @ApiModelProperty(value = "操作方法")
    private String method;
    @ApiModelProperty(value = "请求参数")
    private String params;
    @ApiModelProperty(value = "ip")
    private String ip;
    @ApiModelProperty(value = "请求时间")
    private Date createTime;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getOperation() {
        return operation;
    }

    public Integer getTime() {
        return time;
    }

    public String getMethod() {
        return method;
    }

    public String getParams() {
        return params;
    }

    public String getIp() {
        return ip;
    }

    public Date getCreateTime() {
        return createTime;
    }
}