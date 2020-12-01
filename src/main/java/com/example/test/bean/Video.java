package com.example.test.bean;
public class Video {
    private Integer id;
    private Integer dynamicid;
    private String filename;
    private String filepath;
    public Video() {
        super();
    }
    public Video(Integer id,Integer dynamicid,String filename,String filepath) {
        super();
        this.id = id;
        this.dynamicid = dynamicid;
        this.filename = filename;
        this.filepath = filepath;
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

}
