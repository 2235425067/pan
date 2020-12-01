package com.example.test.service;
import java.util.List;
import com.example.test.bean.Dynamic;
import org.apache.ibatis.annotations.Param;

public interface DynamicService{
    long getDynamicRowCount();
    List<Dynamic> selectDynamic();
    Dynamic selectDynamicById(Integer id);
    int insertDynamic(Dynamic value);
    int insertNonEmptyDynamic(Dynamic value);
    int deleteDynamicById(Integer id);
    int updateDynamicById(Dynamic enti);
    int updateNonEmptyDynamicById(Dynamic enti);
    List<Dynamic> getDynamicByPage(int page,int pagesize);
    int updateLikeNum(Integer id);
}