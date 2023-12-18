package com.mz.auth.service;

import com.mz.auth.entity.ReportVO;

import java.util.List;

/**
 * @description: ReportService
 */
public interface ReportService {

    /**
     * 查询学生的总成绩
     * @return
     */
    List<ReportVO> findStuTotalScore();
}