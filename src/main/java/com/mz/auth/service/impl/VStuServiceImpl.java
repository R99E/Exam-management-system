package com.mz.auth.service.impl;

import com.mz.auth.entity.VstuScore;
import com.mz.auth.mapper.VStuMapper;
import com.mz.auth.query.VStuQuery;
import com.mz.auth.service.VStuService;
import com.mz.auth.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: SysStuServiceImpl 学生成绩列表
 */
@Service
public class VStuServiceImpl implements VStuService {

    @Autowired
    private VStuMapper vstuMapper;
    @Override
    public PageList listPage(VStuQuery vStuQuery) {
        PageList pageList = new PageList();
        //查询总的条数
        Long total = vstuMapper.queryTotal(vStuQuery);
        pageList.setTotal(total);
        //查询每页的数据
        List<VstuScore> vstuScores =  vstuMapper.queryData(vStuQuery);
        pageList.setRows(vstuScores);
        return pageList;
    }
}