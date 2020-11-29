package com.example.test.mapper;
import com.example.test.bean.UserBean;
import java.util.List;
public interface UserMapper{
    long getUserBeanRowCount();
    List<UserBean> selectUserBean();
    UserBean selectUserBeanById(Integer id);
    int insertUserBean(UserBean value);
    int insertNonEmptyUserBean(UserBean value);
    int deleteUserBeanById(Integer id);
    int updateUserBeanById(UserBean enti);
    int updateNonEmptyUserBeanById(UserBean enti);

    UserBean getInfo(String name,String password);
    int Register(UserBean user);
    UserBean chickName(String name);
    UserBean getUser(String name);
}