package com.example.test.mapper;
import com.example.test.bean.Dynamic;
import com.example.test.bean.File;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface DynamicMapper{
    long getDynamicRowCount();
    List<Dynamic> selectDynamic();
    Dynamic selectDynamicById(Integer id);
    int insertDynamic(Dynamic value);
    int insertNonEmptyDynamic(Dynamic value);
    int deleteDynamicById(Integer id);
    int updateDynamicById(Dynamic enti);
    int updateNonEmptyDynamicById(Dynamic enti);

    List<Dynamic> getDynamicByPage(@Param("page") int page, @Param("pagesize") int pagesize);
    int updateLikeNum(Integer id);
}