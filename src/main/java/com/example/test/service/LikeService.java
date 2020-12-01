package com.example.test.service;
import java.util.List;
import com.example.test.bean.Like;
public interface LikeService{
    long getLikeRowCount();
    List<Like> selectLike();
    Like selectLikeById(Integer id);
    int insertLike(Like value);
    int insertNonEmptyLike(Like value);
    int deleteLikeById(Integer id);
    int updateLikeById(Like enti);
    int updateNonEmptyLikeById(Like enti);
}