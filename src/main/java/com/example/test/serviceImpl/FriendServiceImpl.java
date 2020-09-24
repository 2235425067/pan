package com.example.test.serviceImpl;

import com.example.test.bean.Friend;
import com.example.test.mapper.FriendMapper;
import com.example.test.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FriendServiceImpl implements FriendService{
    @Autowired
    private FriendMapper friendMapper;
    @Override
    public long getFriendRowCount(){
        return friendMapper.getFriendRowCount();
    }
    @Override
    public List<Friend> selectFriend(){
        return friendMapper.selectFriend();
    }
    @Override
    public Friend selectFriendById(Integer id){
        return friendMapper.selectFriendById(id);
    }
    @Override
    public int insertFriend(Friend value){
        return friendMapper.insertFriend(value);
    }
    @Override
    public int insertNonEmptyFriend(Friend value){
        return friendMapper.insertNonEmptyFriend(value);
    }
    @Override
    public int deleteFriendById(Integer id){
        return friendMapper.deleteFriendById(id);
    }
    @Override
    public int updateFriendById(Friend enti){
        return friendMapper.updateFriendById(enti);
    }
    @Override
    public int updateNonEmptyFriendById(Friend enti){
        return friendMapper.updateNonEmptyFriendById(enti);
    }

    @Override
    public List<Friend> selectFriendByName(String name) {
        return friendMapper.selectFriendByName(name);
    }

    public FriendMapper getFriendMapper() {
        return this.friendMapper;
    }

    public void setFriendMapper(FriendMapper friendMapper) {
        this.friendMapper = friendMapper;
    }

}