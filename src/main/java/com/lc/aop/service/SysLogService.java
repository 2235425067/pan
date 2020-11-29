package com.lc.aop.service;
import java.util.List;
import com.lc.aop.entity.SysLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;


public interface SysLogService{
    long getSysLogRowCount();
    List<SysLog> selectSysLog();
    SysLog selectSysLogById(Integer id);
    int insertSysLog(SysLog value);
    int insertNonEmptySysLog(SysLog value);
    int deleteSysLogById(Integer id);
    int updateSysLogById(SysLog enti);
    int updateNonEmptySysLogById(SysLog enti);
    List<SysLog> getLogByPage(int page, int pagesize);
}