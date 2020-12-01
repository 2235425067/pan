package com.example.test.mapper;
import com.example.test.bean.Comment;
import java.util.List;
public interface CommentMapper{
    long getCommentRowCount();
    List<Comment> selectComment();
    Comment selectCommentById(Integer id);
    int insertComment(Comment value);
    int insertNonEmptyComment(Comment value);
    int deleteCommentById(Integer id);
    int updateCommentById(Comment enti);
    int updateNonEmptyCommentById(Comment enti);
}