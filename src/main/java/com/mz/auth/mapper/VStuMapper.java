package com.mz.auth.mapper;

import com.mz.auth.entity.VstuScore;
import com.mz.auth.query.VStuQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description:
 */
@Mapper
public interface VStuMapper {

    /**
     * 查询总数据
     * @param vStuQuery
     * @return
     */
    Long queryTotal(VStuQuery vStuQuery);

    /**
     * 分页数据
     * @param vStuQuery
     * @return
     */
    List<VstuScore> queryData(VStuQuery vStuQuery);
}