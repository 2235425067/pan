package com.example.test.bean;
public class Friend {
    private Integer id;
    private String name;
    private String friendname;
    public Friend() {
        super();
    }
    public Friend(Integer id,String name,String friendname) {
        super();
        this.id = id;
        this.name = name;
        this.friendname = friendname;
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

    public String getFriendname() {
        return this.friendname;
    }

    public void setFriendname(String friendname) {
        this.friendname = friendname;
    }

}
