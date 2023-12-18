package com.mz.auth.query;

import lombok.Data;

/**
 * @description:
 */
@Data
public class VStuQuery extends BaseQuery {
    //学生昵称
    private String nickName;
   //试卷名称
    private String name;
}