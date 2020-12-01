package com.example.test.serviceImpl;
import java.util.List;
import com.example.test.mapper.VideoMapper;
import com.example.test.bean.Video;
import com.example.test.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService{
    @Autowired
    private VideoMapper videoMapper;
    @Override
    public long getVideoRowCount(){
        return videoMapper.getVideoRowCount();
    }
    @Override
    public List<Video> selectVideo(){
        return videoMapper.selectVideo();
    }
    @Override
    public Video selectVideoById(Integer id){
        return videoMapper.selectVideoById(id);
    }
    @Override
    public int insertVideo(Video value){
        return videoMapper.insertVideo(value);
    }
    @Override
    public int insertNonEmptyVideo(Video value){
        return videoMapper.insertNonEmptyVideo(value);
    }
    @Override
    public int deleteVideoById(Integer id){
        return videoMapper.deleteVideoById(id);
    }
    @Override
    public int updateVideoById(Video enti){
        return videoMapper.updateVideoById(enti);
    }
    @Override
    public int updateNonEmptyVideoById(Video enti){
        return videoMapper.updateNonEmptyVideoById(enti);
    }

    @Override
    public Video selectVideoByDynamicId(Integer dynamicId) {
        return videoMapper.selectVideoByDynamicId(dynamicId);
    }

    public VideoMapper getVideoMapper() {
        return this.videoMapper;
    }

    public void setVideoMapper(VideoMapper videoMapper) {
        this.videoMapper = videoMapper;
    }

}