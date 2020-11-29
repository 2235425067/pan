package com.example.test.bean;

import io.swagger.annotations.ApiModelProperty;

public class UserBean {
    @ApiModelProperty(value = "用户id",dataType="int")
    private int id=1;
    @ApiModelProperty(value = "用户名")
    private String name;
    @ApiModelProperty(value = "用户密码")
    private String password;
    @ApiModelProperty(value = "用户签名")
    private String signature;
    @ApiModelProperty(value = "用户类型")
    private String role;
    public UserBean() {
        super();
    }
    public UserBean(Integer id,String name,String password,String signature,String role) {
        super();
        this.id = id;
        this.name = name;
        this.password = password;
        this.signature = signature;
        this.role = role;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
