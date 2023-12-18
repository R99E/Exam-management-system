package com.mz.auth.web.controller;

import com.mz.auth.query.VStuQuery;
import com.mz.auth.service.VStuService;
import com.mz.auth.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: VStuController
 */
@Controller
public class VStuController {

    @Autowired
    private VStuService vStuService;
    /**
     * 跳转学生的列表页
     * @return
     */
    @GetMapping("/score/index")
    public String index(){
        return "views/score/score_list";
    }

    /**
     * 成绩查询 分页
     * @return
     */
    @GetMapping("/score/listpage")
    @ResponseBody
    public PageList listPage(VStuQuery vStuQuery){
        return vStuService.listPage(vStuQuery);
    }


}