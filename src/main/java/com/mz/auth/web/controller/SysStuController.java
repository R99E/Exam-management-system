package com.mz.auth.web.controller;

import com.mz.auth.query.SysStuQuery;
import com.mz.auth.service.SysStuService;
import com.mz.auth.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: SysStuController
 */
@Controller
public class SysStuController {

    @Autowired
    private SysStuService sysStuService;
    /**
     * 跳转学生的列表页
     * @return
     */
    @GetMapping("/student/index")
    public String index(){
        return "views/student/student_list";
    }

    /**
     * 学生列表 分页查询数据
     * @return
     */
    @GetMapping("/student/listpage")
    @ResponseBody
    public PageList listPage(SysStuQuery sysStuQuery){
        return sysStuService.listPage(sysStuQuery);
    }


}