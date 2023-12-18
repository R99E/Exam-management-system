package com.mz.auth.query;

import lombok.Data;

@Data
public class BaseQuery {
    //分页的起始页
    private Long offset;
    //每页显示条数
    private Long page;
}