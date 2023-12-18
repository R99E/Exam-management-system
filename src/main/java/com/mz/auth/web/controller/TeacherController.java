package com.mz.auth.web.controller;

import com.mz.auth.entity.ScoreDetail;
import com.mz.auth.entity.User;
import com.mz.auth.query.ScoreDetailQuery;
import com.mz.auth.query.UserQuery;
import com.mz.auth.service.ScoreDetailService;
import com.mz.auth.service.UserService;
import com.mz.auth.util.MzResult;
import com.mz.auth.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TeacherController {
    @Autowired
    private UserService userService;

    @Autowired
    private ScoreDetailService scoreDetailService;




    //注册老师
    @PostMapping("/teacher/regTeacher")
    @ResponseBody
    public MzResult regTeacher(User user){
        try {
            Long userid = userService.addTeacher(user);
            //进入MzResult类
            return MzResult.ok().put("userid",userid); 
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }


    /**
     * 老师列表页
     * @param
     * @return
     */
    @GetMapping("/teacher/index")
    public String index(){
        return "views/teacher/teacher_list";
    }

    //跳转老师阅卷页面
    @GetMapping("/teacher/paperExamRecord")
    public String paperExamRecord(){
        return "views/teacher/paper_check";
    }

    //老师阅卷题目查询
    @GetMapping("/teacher/paperExamlistpage")
    @ResponseBody
    public PageList listPaperExamPage(ScoreDetailQuery scoreDetailQuery){
        return scoreDetailService.listPage(scoreDetailQuery);
    }

    //老师阅卷操作修改得分
    @PostMapping("/teacher/updateJdtScore")
    @ResponseBody
    public MzResult updateJdtScore(ScoreDetail scoreDetail){
        try {
            scoreDetailService.updateJdtScore(scoreDetail);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }

    /**
     * 老师列表分页
     * @param userQuery
     * @return
     */
    @GetMapping("/teacher/listpage")
    @ResponseBody
    public PageList listPage(UserQuery userQuery){
        userQuery.setType(2);//用户类型为2 老师
        //调用userService层 listPage方法，进行分页
        return userService.listPage(userQuery);
    }
}