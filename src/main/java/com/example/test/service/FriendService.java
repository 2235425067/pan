package com.example.test.service;
import java.util.List;
import com.example.test.bean.Friend;
import org.apache.ibatis.annotations.Param;

public interface FriendService{
    long getFriendRowCount();
    List<Friend> selectFriend();
    Friend selectFriendById(Integer id);
    int insertFriend(Friend value);
    int insertNonEmptyFriend(Friend value);
    int deleteFriendById(Integer id);
    int updateFriendById(Friend enti);
    int updateNonEmptyFriendById(Friend enti);
    List<Friend> selectFriendByName(String name);
}