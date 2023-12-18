package com.mz.auth.service.impl;

import com.mz.auth.entity.Log;
import com.mz.auth.mapper.LogMapper;
import com.mz.auth.query.LogQuery;
import com.mz.auth.service.LogService;
import com.mz.auth.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    /**
     * 保存日志方法
     * @param log
     */
    @Override
    public void addLog(Log log) {
        logMapper.addLog(log);
    }

    /**
     * 分页查询方法
     * @param logQuery
     * @return
     */
    @Override
    public PageList listPage(LogQuery logQuery) {
        PageList pageList = new PageList();
        //查询总的条数
        Long total = logMapper.queryTotal(logQuery);
        pageList.setTotal(total);
        //查询每页的数据
        List<Log> logs =  logMapper.queryData(logQuery);
        pageList.setRows(logs);
        return pageList;
    }


}