package com.example.test.mapper;
import com.example.test.bean.Image;
import java.util.List;
public interface ImageMapper{
    long getImageRowCount();
    List<Image> selectImage();
    Image selectImageById(Integer id);
    int insertImage(Image value);
    int insertNonEmptyImage(Image value);
    int deleteImageById(Integer id);
    int updateImageById(Image enti);
    int updateNonEmptyImageById(Image enti);
}