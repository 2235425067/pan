package com.example.test.serviceImpl;
import java.util.List;
import com.example.test.mapper.UserMapper;
import com.example.test.bean.UserBean;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public long getUserBeanRowCount(){
        return userMapper.getUserBeanRowCount();
    }
    @Override
    public List<UserBean> selectUserBean(){
        return userMapper.selectUserBean();
    }
    @Override
    public UserBean selectUserBeanById(Integer id){
        return userMapper.selectUserBeanById(id);
    }
    @Override
    public int insertUserBean(UserBean value){
        return userMapper.insertUserBean(value);
    }
    @Override
    public int insertNonEmptyUserBean(UserBean value){
        return userMapper.insertNonEmptyUserBean(value);
    }
    @Override
    public int deleteUserBeanById(Integer id){
        return userMapper.deleteUserBeanById(id);
    }
    @Override
    public int updateUserBeanById(UserBean enti){
        return userMapper.updateUserBeanById(enti);
    }
    @Override
    public int updateNonEmptyUserBeanById(UserBean enti){
        return userMapper.updateNonEmptyUserBeanById(enti);
    }
    @Override
    public UserBean loginIn(String name, String password) {
        return userMapper.getInfo(name,password);
    }

    @Override
    public int Register(UserBean user) {
        return userMapper.Register(user);
    }

    @Override
    public UserBean chickName(String name) {
        return userMapper.chickName(name);
    }

    @Override
    public UserBean getUser(String name) {
        return userMapper.getUser(name);
    }

    public UserMapper getUserMapper() {
        return this.userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

}