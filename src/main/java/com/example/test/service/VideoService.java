package com.example.test.service;
import java.util.List;
import com.example.test.bean.Video;
public interface VideoService{
    long getVideoRowCount();
    List<Video> selectVideo();
    Video selectVideoById(Integer id);
    int insertVideo(Video value);
    int insertNonEmptyVideo(Video value);
    int deleteVideoById(Integer id);
    int updateVideoById(Video enti);
    int updateNonEmptyVideoById(Video enti);
    Video selectVideoByDynamicId(Integer dynamicId);
}