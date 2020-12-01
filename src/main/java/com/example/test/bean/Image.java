package com.example.test.bean;
public class Image {
    private Integer id;
    private Integer dynamicid;
    private Object image;
    public Image() {
        super();
    }
    public Image(Integer id,Integer dynamicid,Object image) {
        super();
        this.id = id;
        this.dynamicid = dynamicid;
        this.image = image;
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

    public Object getImage() {
        return this.image;
    }

    public void setImage(Object image) {
        this.image = image;
    }

}
