package com.example.test.service;
import java.util.List;
import com.example.test.bean.Comment;
public interface CommentService{
    long getCommentRowCount();
    List<Comment> selectComment();
    Comment selectCommentById(Integer id);
    int insertComment(Comment value);
    int insertNonEmptyComment(Comment value);
    int deleteCommentById(Integer id);
    int updateCommentById(Comment enti);
    int updateNonEmptyCommentById(Comment enti);
    List<Comment> selectCommentByDynamicId(int dynamicId);
}