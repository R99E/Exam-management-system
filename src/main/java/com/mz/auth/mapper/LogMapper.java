
package com.mz.auth.mapper;

import com.mz.auth.entity.Log;
import com.mz.auth.query.LogQuery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description: LogMapper
 */
@Mapper
public interface LogMapper {

    /**
     * 插入日志记录
     * @param log
     */
    @Insert("insert into t_logs(url,http_method,ip,class_method,userid,createTime)" +
            "values(#{url},#{http_method},#{ip},#{class_method},#{userid},#{createTime})")
    void addLog(Log log);

    /**
     * 查询总数
     * @param logQuery
     * @return
     */
    Long queryTotal(LogQuery logQuery);

    /**
     * 分页查询数据方法
     * @param logQuery
     * @return
     */
    List<Log> queryData(LogQuery logQuery);
}