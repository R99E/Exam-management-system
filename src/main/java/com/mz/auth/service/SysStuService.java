
package com.mz.auth.service;

import com.mz.auth.query.SysStuQuery;
import com.mz.auth.query.UserQuery;
import com.mz.auth.util.PageList;

/**
 * @description: SysStuService
 */
public interface SysStuService {

    /**
     * 学生列表 分页查询数据
     * @param sysStuQuery
     * @return
     */
    PageList listPage(SysStuQuery sysStuQuery);
}