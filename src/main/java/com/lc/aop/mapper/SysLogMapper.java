package com.lc.aop.mapper;
import com.lc.aop.entity.SysLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface SysLogMapper{
    long getSysLogRowCount();
    List<SysLog> selectSysLog();
    SysLog selectSysLogById(Integer id);
    int insertSysLog(SysLog value);
    int insertNonEmptySysLog(SysLog value);
    int deleteSysLogById(Integer id);
    int updateSysLogById(SysLog enti);
    int updateNonEmptySysLogById(SysLog enti);
    List<SysLog> getLogByPage(@Param("page") int page, @Param("pagesize") int pagesize);
}