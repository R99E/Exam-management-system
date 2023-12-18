package com.mz.auth.entity;

import lombok.Data;

/**
 * @description: 学生成绩实体类
 */
@Data
public class VstuScore {
  //学生编号
    private Long stuId;
    private Long paperId;//试卷Id
    private String nickName;//学生昵称
    private String name;//试卷名称
    private Integer totalScore;//学生分数
}