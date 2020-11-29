package com.lc.aop.dao.impl;

import com.lc.aop.dao.SysLogDao;
import com.lc.aop.domain.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
class SysLogDaoImpl implements SysLogDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveSysLog(SysLog syslog) {

        System.out.println(syslog);

        StringBuffer sql = new StringBuffer("insert into sys_log ");
        sql.append("(id,username,operation,time,method,params,ip,create_time) ");
        sql.append("values(NULL,?,?,?,?,?,?,?)");
        String sql2=sql.toString();
        jdbcTemplate.update(sql2,syslog.getUsername(),syslog.getOperation(),syslog.getTime(),syslog.getMethod(),syslog.getParams(),syslog.getIp(),syslog.getCreateTime());
        //jdbcTemplate.update(sql2);

    }
}