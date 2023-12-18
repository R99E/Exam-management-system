package com.mz.auth.web.controller.front;

import com.mz.auth.entity.ScoreDetail;
import com.mz.auth.query.PaperQuery;
import com.mz.auth.service.PaperService;
import com.mz.auth.service.ScoreDetailService;
import com.mz.auth.util.CodeUtil;
import com.mz.auth.util.MzResult;
import com.mz.auth.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class FrontIndexController {

    @Autowired
    private PaperService paperService;

    @Autowired
    private ScoreDetailService scoreDetailService;

    //跳转学生登录页
    @RequestMapping("/front/login")
    public String gotoLoginPage(){
        return "front/loginIndex";
    }
    //跳转学生注册页
    @RequestMapping("/front/gotoRegPage")
    public String gotoRegPage(){
        return "front/regIndex";
    }

    //生成验证码
    @RequestMapping("/front/getCode")
    public void getCode(HttpSession session, HttpServletResponse resp){
        // 调用工具类生成的验证码和验证码图片
        Map<String, Object> codeMap = CodeUtil.generateCodeAndPic();
        session.setAttribute("code", codeMap.get("code").toString());

        // 设置响应头 禁止图像缓存。
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", -1);
        resp.setContentType("image/jpeg");
        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos;
        try {
            sos = resp.getOutputStream();
            ImageIO.write((RenderedImage) codeMap.get("codePic"), "jpeg", sos);
            sos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //跳转前台首页面
    @RequestMapping("/front/index")
    public String index(){
        return "front/frontIndex";
    }

    //前台首页的方法
    @GetMapping("/paperindex/listpage")
    @ResponseBody
    public PageList listPage(PaperQuery paperQuery){
        return paperService.listPage(paperQuery);
    }



    //保存学生考试记录
    @RequestMapping("/stu/examPaper")
    @ResponseBody
    public MzResult examPaper(@RequestBody List<ScoreDetail> scoreDetails){
        //@RequestBody前台是json形式的数据 到后台
        try {
            scoreDetailService.savePaperTestRecord(scoreDetails);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }

}