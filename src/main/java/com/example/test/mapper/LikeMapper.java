package com.example.test.mapper;
import com.example.test.bean.Like;
import java.util.List;
public interface LikeMapper{
    long getLikeRowCount();
    List<Like> selectLike();
    Like selectLikeById(Integer id);
    int insertLike(Like value);
    int insertNonEmptyLike(Like value);
    int deleteLikeById(Integer id);
    int updateLikeById(Like enti);
    int updateNonEmptyLikeById(Like enti);


}