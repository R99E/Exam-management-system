package com.mz.auth.mapper;

import com.mz.auth.entity.ReportVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @description:
 */
@Mapper
public interface ReportMapper {

    /**
     * 查询每个学生的总成绩
     * @return
     */
    @Select("select s.nickName,sum(es.correntScore) totalScore from \n" +
            "t_student s \n" +
            "join exam_scoredetail es on s.id = es.stuId\n" +
            "group by s.id")
    List<ReportVO> findStuTotalScore();
}