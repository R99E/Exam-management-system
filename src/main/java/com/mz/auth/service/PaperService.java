package com.mz.auth.service;

import com.mz.auth.entity.Paper;
import com.mz.auth.entity.PaperQuestion;
import com.mz.auth.query.PaperQuery;
import com.mz.auth.util.PageList;
import com.mz.auth.vo.PaperGengerateVO;
import com.mz.auth.vo.TypeTotalVO;

import java.util.List;
import java.util.Map;

public interface PaperService {
    //分页查询数据
    PageList listPage(PaperQuery paperQuery);

    void savePaper(Paper paper);

    void deletePaper(Long id);

    //查询所有试卷
    List<Paper> queryPaper();

    //根据试卷id查询所有的问题
    List<PaperQuestion> queryQuestionByPaperId(Long paperId);

    //手动组卷
    void diyPaperQuestion(PaperQuestion paperQuestion);

    //查询题类型的总数
    List<TypeTotalVO> queryTypeTotal();

    void randomPaperQuestion(Map mp);

    //根据id查询预览试卷信息
    PaperGengerateVO previewPaper(Long paperId);

    //前台查询试卷
    List<Paper> findPapers();

}