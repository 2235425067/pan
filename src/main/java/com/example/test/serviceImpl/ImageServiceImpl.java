package com.example.test.serviceImpl;
import java.util.List;
import com.example.test.mapper.ImageMapper;
import com.example.test.bean.Image;
import com.example.test.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService{
    @Autowired
    private ImageMapper imageMapper;
    @Override
    public long getImageRowCount(){
        return imageMapper.getImageRowCount();
    }
    @Override
    public List<Image> selectImage(){
        return imageMapper.selectImage();
    }
    @Override
    public Image selectImageById(Integer id){
        return imageMapper.selectImageById(id);
    }
    @Override
    public int insertImage(Image value){
        return imageMapper.insertImage(value);
    }
    @Override
    public int insertNonEmptyImage(Image value){
        return imageMapper.insertNonEmptyImage(value);
    }
    @Override
    public int deleteImageById(Integer id){
        return imageMapper.deleteImageById(id);
    }
    @Override
    public int updateImageById(Image enti){
        return imageMapper.updateImageById(enti);
    }
    @Override
    public int updateNonEmptyImageById(Image enti){
        return imageMapper.updateNonEmptyImageById(enti);
    }

    public ImageMapper getImageMapper() {
        return this.imageMapper;
    }

    public void setImageMapper(ImageMapper imageMapper) {
        this.imageMapper = imageMapper;
    }

}