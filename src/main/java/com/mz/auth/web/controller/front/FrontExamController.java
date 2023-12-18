package com.mz.auth.web.controller.front;

import com.mz.auth.service.PaperService;
import com.mz.auth.vo.PaperGengerateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontExamController {
    @Autowired
    private PaperService paperService;
    //前台弹出测试（考试）页面
    @RequestMapping("/exam/popPaper/{paperId}")
    public String popPaper(Model model , @PathVariable("paperId") Long paperId){
        PaperGengerateVO paperGengerateVO = paperService.previewPaper(paperId);
        model.addAttribute("examPapersVO",paperGengerateVO);
        return "front/examPaper";
    }
}