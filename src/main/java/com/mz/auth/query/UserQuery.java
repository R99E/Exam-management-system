package com.mz.auth.query;

import lombok.Data;

@Data
public class UserQuery extends BaseQuery{
    // username 用户名
    private String username;
    // email 邮件
    private String email;

    /**
     * type 用户类型  type=1表示管理员
     * type=2表示老师
     */
    private Integer type;
}