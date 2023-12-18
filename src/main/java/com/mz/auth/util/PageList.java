package com.mz.auth.util;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PageList {
    //查询总的条数
    private Long total;
    //分页数据集合
    private List rows = new ArrayList<>();

}