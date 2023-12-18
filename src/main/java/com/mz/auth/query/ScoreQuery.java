package com.mz.auth.query;

import lombok.Data;

/**
 * @ClassName ScoreQuery
 * @Description
 * @Author Administrator
 * @Time 2023/7/4 11:53
 * @Version 1.0
 */

@Data
public class ScoreQuery extends BaseQuery{
    //当前的登录用户的ID
    private Long stuId;

    //试题的编号
    private Long paperId;
}
