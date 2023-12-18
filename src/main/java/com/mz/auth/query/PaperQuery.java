package com.mz.auth.query;

import lombok.Data;

@Data
public class PaperQuery extends BaseQuery{//extends BaseQuery

    private Long id;
	//试卷名称
    private String name;



}