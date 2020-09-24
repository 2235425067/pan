package com.example.test.mapper;
import com.example.test.bean.Friendmessage;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
public interface FriendmessageMapper{
    long getFriendmessageRowCount();
    List<Friendmessage> selectFriendmessage();
    Friendmessage selectFriendmessageById(Integer id);
    int insertFriendmessage(Friendmessage value);
    int insertNonEmptyFriendmessage(Friendmessage value);
    int deleteFriendmessageById(Integer id);
    int updateFriendmessageById(Friendmessage enti);
    int updateNonEmptyFriendmessageById(Friendmessage enti);
    List<HashMap<String,Object>> getAllMessageByPage(@Param("page") int page,@Param("pagesize") int pagesize,
                                                     @Param("fromName")String fromName,@Param("toName") String toName);
}