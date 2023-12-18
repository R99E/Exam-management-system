package com.mz.auth.web.controller;

import com.mz.auth.entity.ReportVO;
import com.mz.auth.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @description: ReportController
 */
@Controller
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * 跳转到报表页面
     * @return
     */
    @GetMapping("/report/index")
    public String index(){
        return "views/report/report_list";
    }

    /**
     * 查询学生的总成绩，展示在报表上面
     * @return
     */
    @PostMapping("/report/getData")
    @ResponseBody
    public List<ReportVO> getData(){
        return reportService.findStuTotalScore();
    }
}