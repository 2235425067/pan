package com.example.test.mapper;
import com.alibaba.druid.wall.Violation;
import com.example.test.bean.Video;
import java.util.List;
public interface VideoMapper{
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