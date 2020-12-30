package com.example.test.service;
import java.util.List;
import com.example.test.bean.File;
import org.apache.ibatis.annotations.Param;

public interface FileService{
    long getFileRowCount();
    List<File> selectFile();
    File selectFileById(Integer id);
    File selectFileByPath(String path,String fileName);
    int insertFile(File value);
    int insertNonEmptyFile(File value);
    int deleteFileById(Integer id);
    int updateFileById(File enti);
    int updateNonEmptyFileById(File enti);
    List<File> getCheckFileByPage(int page, int pagesize);
    long getCheckFileRowCount();
    long getFinishFileRowCount();
    int updateNonEmptyFileByPath(String filepath);
    List<File> getFinishFileByPage(int page, int pagesize);
}