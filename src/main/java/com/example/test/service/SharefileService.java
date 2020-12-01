package com.example.test.service;
import java.util.List;
import com.example.test.bean.Sharefile;
public interface SharefileService{
    long getSharefileRowCount();
    List<Sharefile> selectSharefile();
    Sharefile selectSharefileById(Integer id);
    int insertSharefile(Sharefile value);
    int insertNonEmptySharefile(Sharefile value);
    int deleteSharefileById(Integer id);
    int updateSharefileById(Sharefile enti);
    int updateNonEmptySharefileById(Sharefile enti);

    Sharefile selectSharefileByCode(String code);
    List<Sharefile> selectSharefileByUsername(String username);
}