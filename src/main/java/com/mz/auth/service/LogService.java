package com.mz.auth.service;

import com.mz.auth.entity.Log;
import com.mz.auth.query.LogQuery;
import com.mz.auth.util.PageList;

/**
 * @description: LogService
 */
public interface LogService {
    /**
     * 加入日志
     * @param log
     */
    void addLog(Log log);


    /**
     * 分页查询方法
     * @param logQuery
     * @return
     */
    PageList listPage(LogQuery logQuery);
}