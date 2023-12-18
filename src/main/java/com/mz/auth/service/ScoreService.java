package com.mz.auth.service;

import com.mz.auth.query.ScoreQuery;
import com.mz.auth.util.PageList;


public interface ScoreService {
    //分页查询数据
    PageList listPage(ScoreQuery scoreQuery);
}
