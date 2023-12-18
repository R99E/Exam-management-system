
package com.mz.auth.service.impl;

import com.mz.auth.entity.Student;
import com.mz.auth.entity.User;
import com.mz.auth.mapper.SysStuMapper;
import com.mz.auth.query.SysStuQuery;
import com.mz.auth.service.SysStuService;
import com.mz.auth.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: SysStuServiceImpl
 */
@Service
public class SysStuServiceImpl implements SysStuService {

    @Autowired
    private SysStuMapper sysStuMapper;
    @Override
    public PageList listPage(SysStuQuery sysStuQuery) {
        PageList pageList = new PageList();
        //查询总的条数
        Long total = sysStuMapper.queryTotal(sysStuQuery);
        pageList.setTotal(total);
        //查询每页的数据
        List<Student> students =  sysStuMapper.queryData(sysStuQuery);
        pageList.setRows(students);
        return pageList;
    }
}