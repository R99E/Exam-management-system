package com.mz.auth.service;

import com.mz.auth.query.VStuQuery;
import com.mz.auth.util.PageList;

/**
 * @description: SysStuService
 */
public interface VStuService {

    /**
     * 分页查询数据
     * @param vStuQuery
     * @return
     */
    PageList listPage(VStuQuery vStuQuery);
}