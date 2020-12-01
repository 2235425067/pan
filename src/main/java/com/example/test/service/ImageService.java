package com.example.test.service;
import java.util.List;
import com.example.test.bean.Image;
public interface ImageService{
    long getImageRowCount();
    List<Image> selectImage();
    Image selectImageById(Integer id);
    int insertImage(Image value);
    int insertNonEmptyImage(Image value);
    int deleteImageById(Integer id);
    int updateImageById(Image enti);
    int updateNonEmptyImageById(Image enti);
}