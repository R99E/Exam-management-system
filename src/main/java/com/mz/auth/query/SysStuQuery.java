package com.mz.auth.query;

import lombok.Data;

/**
 * @description: 学生实体表
 */
@Data
public class SysStuQuery extends BaseQuery {
    //学生姓名
    private String username;
}