package com.example.test.serviceImpl;
import java.util.List;

import com.example.test.bean.SharefileBean;
import com.example.test.mapper.SharefileMapper;
import com.example.test.bean.Sharefile;
import com.example.test.service.SharefileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SharefileServiceImpl implements SharefileService{
    @Autowired
    private SharefileMapper sharefileMapper;
    @Override
    public long getSharefileRowCount(){
        return sharefileMapper.getSharefileRowCount();
    }
    @Override
    public List<Sharefile> selectSharefile(){
        return sharefileMapper.selectSharefile();
    }
    @Override
    public Sharefile selectSharefileById(Integer id){
        return sharefileMapper.selectSharefileById(id);
    }
    @Override
    public int insertSharefile(Sharefile value){
        return sharefileMapper.insertSharefile(value);
    }
    @Override
    public int insertNonEmptySharefile(Sharefile value){
        return sharefileMapper.insertNonEmptySharefile(value);
    }
    @Override
    public int deleteSharefileById(Integer id){
        return sharefileMapper.deleteSharefileById(id);
    }
    @Override
    public int updateSharefileById(Sharefile enti){
        return sharefileMapper.updateSharefileById(enti);
    }
    @Override
    public int updateNonEmptySharefileById(Sharefile enti){
        return sharefileMapper.updateNonEmptySharefileById(enti);
    }

    @Override
    public Sharefile selectSharefileByCode(String code) {
        return sharefileMapper.selectSharefileByCode(code);
    }

    @Override
    public List<Sharefile> selectSharefileByUsername(String username) {
        return sharefileMapper.selectSharefileByUsername(username);
    }

    @Override
    public List<SharefileBean> selectSharefileBeanByUsername(String username) {
        return sharefileMapper.selectSharefileBeanByUsername(username);
    }

    @Override
    public SharefileBean selectSharefileBeanByCode(String code) {
        return sharefileMapper.selectSharefileBeanByCode(code);
    }

    public SharefileMapper getSharefileMapper() {
        return this.sharefileMapper;
    }

    public void setSharefileMapper(SharefileMapper sharefileMapper) {
        this.sharefileMapper = sharefileMapper;
    }

}