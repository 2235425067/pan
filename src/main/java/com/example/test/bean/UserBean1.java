package com.example.test.bean;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class UserBean1 {
    @ApiModelProperty(value = "用户id")
    private int id;
    @ApiModelProperty(value = "用户名")
    private String name;
    @ApiModelProperty(value = "用户密码")
    private String password;
    @ApiModelProperty(value = "用户签名")
    private String signature;
    @ApiModelProperty(value = "用户类型")
    private String role;

    public String getSignature() {
        return signature;
    }

    public String getRole() {
        return role;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserBean1(String name, String password){
        this.name=name;
        this.password=password;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
