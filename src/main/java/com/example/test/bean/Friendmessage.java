package com.example.test.bean;
public class Friendmessage {
    private Integer id;
    private String fromname;
    private String toname;
    private String message;
    private java.util.Date time;
    private Integer type;
    public Friendmessage() {
        super();
    }
    public Friendmessage(Integer id,String fromname,String toname,String message,java.util.Date time,Integer type) {
        super();
        this.id = id;
        this.fromname = fromname;
        this.toname = toname;
        this.message = message;
        this.time = time;
        this.type = type;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromname() {
        return this.fromname;
    }

    public void setFromname(String fromname) {
        this.fromname = fromname;
    }

    public String getToname() {
        return this.toname;
    }

    public void setToname(String toname) {
        this.toname = toname;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public java.util.Date getTime() {
        return this.time;
    }

    public void setTime(java.util.Date time) {
        this.time = time;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
