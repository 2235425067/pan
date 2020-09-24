package com.example.test.serviceImpl;
import java.util.HashMap;
import java.util.List;
import com.example.test.mapper.FriendmessageMapper;
import com.example.test.bean.Friendmessage;
import com.example.test.service.FriendmessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendmessageServiceImpl implements FriendmessageService{
    @Autowired
    private FriendmessageMapper friendmessageMapper;
    @Override
    public long getFriendmessageRowCount(){
        return friendmessageMapper.getFriendmessageRowCount();
    }
    @Override
    public List<Friendmessage> selectFriendmessage(){
        return friendmessageMapper.selectFriendmessage();
    }
    @Override
    public Friendmessage selectFriendmessageById(Integer id){
        return friendmessageMapper.selectFriendmessageById(id);
    }
    @Override
    public int insertFriendmessage(Friendmessage value){
        return friendmessageMapper.insertFriendmessage(value);
    }
    @Override
    public int insertNonEmptyFriendmessage(Friendmessage value){
        return friendmessageMapper.insertNonEmptyFriendmessage(value);
    }
    @Override
    public int deleteFriendmessageById(Integer id){
        return friendmessageMapper.deleteFriendmessageById(id);
    }
    @Override
    public int updateFriendmessageById(Friendmessage enti){
        return friendmessageMapper.updateFriendmessageById(enti);
    }
    @Override
    public int updateNonEmptyFriendmessageById(Friendmessage enti){
        return friendmessageMapper.updateNonEmptyFriendmessageById(enti);
    }

    @Override
    public List<HashMap<String, Object>> getAllMessageByPage(int page, int pagesize, String fromName, String toName) {
        return friendmessageMapper.getAllMessageByPage(page,pagesize,fromName,toName);
    }

    public FriendmessageMapper getFriendmessageMapper() {
        return this.friendmessageMapper;
    }

    public void setFriendmessageMapper(FriendmessageMapper friendmessageMapper) {
        this.friendmessageMapper = friendmessageMapper;
    }

}