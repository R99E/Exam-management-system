package com.mz.auth.service.impl;

import com.mz.auth.query.ScoreQuery;
import com.mz.auth.service.ScoreService;
import com.mz.auth.util.PageList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class ScoreServiceImpl implements ScoreService {
    @Override
    public PageList listPage(ScoreQuery scoreQuery) {
        return null;
    }

/*    @Autowired
    private ScoreMapper scoreMapper;

    //分页查询数据
    @Override
    public PageList listPage(PaperQuery paperQuery) {
        PageList pageList = new PageList();
        //查询总的条数
        Long total = scoreMapper.queryTotal(paperQuery);
        pageList.setTotal(total);
        //查询每页的数据
        List<Paper> papers =  scoreMapper.queryData(paperQuery);
        pageList.setRows(papers);
        return pageList;
    }*/
}
