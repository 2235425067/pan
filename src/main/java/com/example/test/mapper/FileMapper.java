package com.example.test.mapper;
import com.example.test.bean.File;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface FileMapper{
    long getFileRowCount();
    List<File> selectFile();
    File selectFileById(Integer id);
    int insertFile(File value);
    int insertNonEmptyFile(File value);
    int deleteFileById(Integer id);
    int updateFileById(File enti);
    int updateNonEmptyFileById(File enti);
    List<File> getCheckFileByPage(@Param("page") int page, @Param("pagesize") int pagesize);
    long getCheckFileRowCount();
}