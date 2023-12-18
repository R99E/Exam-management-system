package com.mz.auth.service.impl;

import com.mz.auth.entity.ReportVO;
import com.mz.auth.mapper.ReportMapper;
import com.mz.auth.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportMapper reportMapper;

    /**
     * 查询学生的总成绩，展示在报表上面，查询到的数据返回到ReportVO实体类里面
     * @return
     */
    @Override
    public List<ReportVO> findStuTotalScore() {
        return reportMapper.findStuTotalScore();
    }
}