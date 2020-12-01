package com.example.test.service;
import java.util.List;
import com.example.test.bean.File;
import org.apache.ibatis.annotations.Param;

public interface FileService{
    long getFileRowCount();
    List<File> selectFile();
    File selectFileById(Integer id);
    int insertFile(File value);
    int insertNonEmptyFile(File value);
    int deleteFileById(Integer id);
    int updateFileById(File enti);
    int updateNonEmptyFileById(File enti);
    List<File> getCheckFileByPage(int page, int pagesize);
    long getCheckFileRowCount();
}