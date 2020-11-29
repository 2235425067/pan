package com.example.test.mapper;

import com.example.test.bean.UserBean;

public interface UserMapper1 {

    UserBean getInfo(String name,String password);
    int Register(UserBean user);
    UserBean chickName(String name);
    UserBean getUser(String name);
}
