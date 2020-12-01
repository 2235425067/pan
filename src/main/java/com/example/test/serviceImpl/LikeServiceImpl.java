package com.example.test.serviceImpl;
import java.util.List;
import com.example.test.mapper.LikeMapper;
import com.example.test.bean.Like;
import com.example.test.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService{
    @Autowired
    private LikeMapper likeMapper;
    @Override
    public long getLikeRowCount(){
        return likeMapper.getLikeRowCount();
    }
    @Override
    public List<Like> selectLike(){
        return likeMapper.selectLike();
    }
    @Override
    public Like selectLikeById(Integer id){
        return likeMapper.selectLikeById(id);
    }
    @Override
    public int insertLike(Like value){
        return likeMapper.insertLike(value);
    }
    @Override
    public int insertNonEmptyLike(Like value){
        return likeMapper.insertNonEmptyLike(value);
    }
    @Override
    public int deleteLikeById(Integer id){
        return likeMapper.deleteLikeById(id);
    }
    @Override
    public int updateLikeById(Like enti){
        return likeMapper.updateLikeById(enti);
    }
    @Override
    public int updateNonEmptyLikeById(Like enti){
        return likeMapper.updateNonEmptyLikeById(enti);
    }

    public LikeMapper getLikeMapper() {
        return this.likeMapper;
    }

    public void setLikeMapper(LikeMapper likeMapper) {
        this.likeMapper = likeMapper;
    }

}