package com.example.test.serviceImpl;
import java.util.List;
import com.example.test.mapper.FileMapper;
import com.example.test.bean.File;
import com.example.test.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService{
    @Autowired
    private FileMapper fileMapper;
    @Override
    public long getFileRowCount(){
        return fileMapper.getFileRowCount();
    }
    @Override
    public List<File> selectFile(){
        return fileMapper.selectFile();
    }
    @Override
    public File selectFileById(Integer id){
        return fileMapper.selectFileById(id);
    }

    @Override
    public File selectFileByPath(String path ,String fileName) {
        return fileMapper.selectFileByPath(path,fileName);
    }

    @Override
    public int insertFile(File value){
        return fileMapper.insertFile(value);
    }
    @Override
    public int insertNonEmptyFile(File value){
        return fileMapper.insertNonEmptyFile(value);
    }
    @Override
    public int deleteFileById(Integer id){
        return fileMapper.deleteFileById(id);
    }
    @Override
    public int updateFileById(File enti){
        return fileMapper.updateFileById(enti);
    }
    @Override
    public int updateNonEmptyFileById(File enti){
        return fileMapper.updateNonEmptyFileById(enti);
    }

    @Override
    public List<File> getCheckFileByPage(int page, int pagesize) {
        return fileMapper.getCheckFileByPage(page,pagesize);
    }

    @Override
    public long getCheckFileRowCount() {
        return fileMapper.getCheckFileRowCount();
    }

    @Override
    public long getFinishFileRowCount() {
        return fileMapper.getFinishFileRowCount();
    }

    @Override
    public int updateNonEmptyFileByPath(String filepath) {
        return fileMapper.updateNonEmptyFileByPath(filepath);
    }

    @Override
    public List<File> getFinishFileByPage(int page, int pagesize) {
        return fileMapper.getFinishFileByPage(page,pagesize);
    }

    public FileMapper getFileMapper() {
        return this.fileMapper;
    }

    public void setFileMapper(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

}