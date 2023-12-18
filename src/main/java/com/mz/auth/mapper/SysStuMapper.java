
package com.mz.auth.mapper;

import com.mz.auth.entity.Student;
import com.mz.auth.query.SysStuQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description: SysStuMapper
 */
@Mapper
public interface SysStuMapper {
    /**
     * 查询总数据
     * @param sysStuQuery
     * @return
     */
    Long queryTotal(SysStuQuery sysStuQuery);

    /**
     * 分页数据
     * @param sysStuQuery
     * @return
     */
    List<Student> queryData(SysStuQuery sysStuQuery);
}