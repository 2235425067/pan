package com.example.test.mapper;
import com.example.test.bean.Friend;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface FriendMapper{
    long getFriendRowCount();
    List<Friend> selectFriend();
    Friend selectFriendById(Integer id);
    int insertFriend(Friend value);
    int insertNonEmptyFriend(Friend value);
    int deleteFriendById(Integer id);
    int updateFriendById(Friend enti);
    int updateNonEmptyFriendById(Friend enti);
    List<Friend> selectFriendByName(@Param("name") String name);
}