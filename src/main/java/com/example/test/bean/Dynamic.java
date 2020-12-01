package com.example.test.bean;
public class Dynamic {
    private Integer id;
    private Object content;
    private java.util.Date time;
    private Integer likenum;
    private String username;
    public Dynamic() {
        super();
    }
    public Dynamic(Integer id,Object content,java.util.Date time,Integer likenum,String username) {
        super();
        this.id = id;
        this.content = content;
        this.time = time;
        this.likenum = likenum;
        this.username = username;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getContent() {
        return this.content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public java.util.Date getTime() {
        return this.time;
    }

    public void setTime(java.util.Date time) {
        this.time = time;
    }

    public Integer getLikenum() {
        return this.likenum;
    }

    public void setLikenum(Integer likenum) {
        this.likenum = likenum;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
