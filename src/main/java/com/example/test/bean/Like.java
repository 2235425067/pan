package com.example.test.bean;
public class Like {
    private Integer id;
    private Integer dynamicid;
    private String username;
    private java.util.Date time;
    public Like() {
        super();
    }
    public Like(Integer id,Integer dynamicid,String username,java.util.Date time) {
        super();
        this.id = id;
        this.dynamicid = dynamicid;
        this.username = username;
        this.time = time;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDynamicid() {
        return this.dynamicid;
    }

    public void setDynamicid(Integer dynamicid) {
        this.dynamicid = dynamicid;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public java.util.Date getTime() {
        return this.time;
    }

    public void setTime(java.util.Date time) {
        this.time = time;
    }

}
