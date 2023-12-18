package com.mz.auth.web.controller;

import com.mz.auth.query.LogQuery;
import com.mz.auth.service.LogService;
import com.mz.auth.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 */
@Controller
public class LogController {

    @Autowired
    private LogService logService;


    /**
     * 跳转日志的列表页
     * @return
     */
    @GetMapping("/log/index")
    public String index(){
        return "views/log/log_list";
    }

    /**
     * 分页
     * @param logQuery
     * @return
     */
    @GetMapping("/log/listpage")
    @ResponseBody
    public PageList listPage(LogQuery logQuery){

        return logService.listPage(logQuery);
    }
}