package com.example.test.service;
import java.util.HashMap;
import java.util.List;
import com.example.test.bean.Friendmessage;
import org.apache.ibatis.annotations.Param;

public interface FriendmessageService{
    long getFriendmessageRowCount();
    List<Friendmessage> selectFriendmessage();
    Friendmessage selectFriendmessageById(Integer id);
    int insertFriendmessage(Friendmessage value);
    int insertNonEmptyFriendmessage(Friendmessage value);
    int deleteFriendmessageById(Integer id);
    int updateFriendmessageById(Friendmessage enti);
    int updateNonEmptyFriendmessageById(Friendmessage enti);
    List<HashMap<String,Object>> getAllMessageByPage(int page,int pagesize, String fromName, String toName);
}