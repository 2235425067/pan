package com.lc.aop.service.Impl;
import java.util.List;
import com.lc.aop.mapper.SysLogMapper;
import com.lc.aop.entity.SysLog;
import com.lc.aop.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysLogServiceImpl implements SysLogService{
    @Autowired
    private SysLogMapper sysLogMapper;
    @Override
    public long getSysLogRowCount(){
        return sysLogMapper.getSysLogRowCount();
    }
    @Override
    public List<SysLog> selectSysLog(){
        return sysLogMapper.selectSysLog();
    }
    @Override
    public SysLog selectSysLogById(Integer id){
        return sysLogMapper.selectSysLogById(id);
    }
    @Override
    public int insertSysLog(SysLog value){
        return sysLogMapper.insertSysLog(value);
    }
    @Override
    public int insertNonEmptySysLog(SysLog value){
        return sysLogMapper.insertNonEmptySysLog(value);
    }
    @Override
    public int deleteSysLogById(Integer id){
        return sysLogMapper.deleteSysLogById(id);
    }
    @Override
    public int updateSysLogById(SysLog enti){
        return sysLogMapper.updateSysLogById(enti);
    }
    @Override
    public int updateNonEmptySysLogById(SysLog enti){
        return sysLogMapper.updateNonEmptySysLogById(enti);
    }

    @Override
    public List<SysLog> getLogByPage(int page, int pagesize) {
        return sysLogMapper.getLogByPage(page,pagesize);
    }


    public SysLogMapper getSysLogMapper() {
        return this.sysLogMapper;
    }

    public void setSysLogMapper(SysLogMapper sysLogMapper) {
        this.sysLogMapper = sysLogMapper;
    }

}