package com.example.test.bean;

import io.swagger.annotations.ApiModelProperty;

public class Sharefile {
    @ApiModelProperty(value = "id",dataType="int")
    private Integer id;
    @ApiModelProperty(value = "分享秘钥")
    private String code;
    @ApiModelProperty(value = "文件id")
    private Integer fileid;
    @ApiModelProperty(value = "分享时间")
    private java.util.Date sharetime;
    @ApiModelProperty(value = "分享人")
    private String username;
    public Sharefile() {
        super();
    }
    public Sharefile(Integer id, String code, Integer fileid, java.util.Date sharetime, String username) {
        super();
        this.id = id;
        this.code = code;
        this.fileid = fileid;
        this.sharetime = sharetime;
        this.username = username;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getFileid() {
        return this.fileid;
    }

    public void setFileid(Integer fileid) {
        this.fileid = fileid;
    }

    public java.util.Date getSharetime() {
        return this.sharetime;
    }

    public void setSharetime(java.util.Date sharetime) {
        this.sharetime = sharetime;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
