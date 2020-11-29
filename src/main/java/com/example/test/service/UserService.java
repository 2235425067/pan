package com.example.test.service;
import java.util.List;
import com.example.test.bean.UserBean;
public interface UserService{
    long getUserBeanRowCount();
    List<UserBean> selectUserBean();
    UserBean selectUserBeanById(Integer id);
    int insertUserBean(UserBean value);
    int insertNonEmptyUserBean(UserBean value);
    int deleteUserBeanById(Integer id);
    int updateUserBeanById(UserBean enti);
    int updateNonEmptyUserBeanById(UserBean enti);

    UserBean loginIn(String name,String password);
    int Register(UserBean user);
    UserBean chickName(String name);
    UserBean getUser(String name);
}