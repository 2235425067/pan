package com.example.test.serviceImpl;

import com.example.test.bean.Comment;
import com.example.test.mapper.CommentMapper;
import com.example.test.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public long getCommentRowCount(){
        return commentMapper.getCommentRowCount();
    }
    @Override
    public List<Comment> selectComment(){
        return commentMapper.selectComment();
    }
    @Override
    public Comment selectCommentById(Integer id){
        return commentMapper.selectCommentById(id);
    }
    @Override
    public int insertComment(Comment value){
        return commentMapper.insertComment(value);
    }
    @Override
    public int insertNonEmptyComment(Comment value){
        return commentMapper.insertNonEmptyComment(value);
    }
    @Override
    public int deleteCommentById(Integer id){
        return commentMapper.deleteCommentById(id);
    }
    @Override
    public int updateCommentById(Comment enti){
        return commentMapper.updateCommentById(enti);
    }
    @Override
    public int updateNonEmptyCommentById(Comment enti){
        return commentMapper.updateNonEmptyCommentById(enti);
    }

    public CommentMapper getCommentMapper() {
        return this.commentMapper;
    }

    public void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

}