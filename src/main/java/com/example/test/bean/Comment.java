package com.example.test.bean;
public class Comment {
    private Integer id;
    private Integer dynamicid;
    private String content;
    private java.util.Date time;
    private String username;
    public Comment() {
        super();
    }
    public Comment(Integer id,Integer dynamicid,String content,java.util.Date time,String username) {
        super();
        this.id = id;
        this.dynamicid = dynamicid;
        this.content = content;
        this.time = time;
        this.username = username;
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

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public java.util.Date getTime() {
        return this.time;
    }

    public void setTime(java.util.Date time) {
        this.time = time;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
