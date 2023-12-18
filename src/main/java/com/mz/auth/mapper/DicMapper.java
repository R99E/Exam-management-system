package com.mz.auth.mapper;

import com.mz.auth.entity.DicType;
import com.mz.auth.entity.DicTypeData;
import com.mz.auth.query.DicQuery;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: DicMapper
 */
@Mapper
public interface DicMapper {
    /**
     * 查询所有的数据字典类型
     * @return
     */
    @Select("select * from t_dictype")
    List<DicType> queryDicType();

    /**
     * 查询总数的方法
     * @param dicQuery
     * @return
     */
    @Select("select count(*) from t_dictype_data")
    @ResultType(Long.class)
    Long queryTotal(DicQuery dicQuery);

    /**
     * 查询分页的数据方法
     * @param dicQuery
     * @return
     */
    @Select("select * from t_dictype_data limit #{offset},#{page}")
    @ResultType(DicTypeData.class)
    List<DicTypeData> queryData(DicQuery dicQuery);

    /**
     * 根据类型id 查询所有的类型数据的集合
     * @param typeid
     * @return
     */
    @Select("select id from t_dictype_data where typeid=#{typeid}")
    List<Long> queryDicTypeDataIdsByTypeid(Long typeid);

    /**
     * 保存数据字典类型
     * @param dicType
     */
    @Insert("insert into t_dictype(sn,info) values(#{sn},#{info})")
    void saveDicType(DicType dicType);

    /**
     * 根据id查询字典类型
     * @param id
     * @return
     */
    @Select("select * from t_dictype where id=#{id}")
    DicType queryDicTypeInfoById(Long id);

    /**
     * 修改保存字典类型
     * @param dicType
     */
    @Update("update t_dictype set sn=#{sn},info=#{info} where id=#{id}")
    void editSaveDicType(DicType dicType);

    /**
     * 新增保存字典类型数据
     * @param dicTypeData
     */
    @Insert("insert into t_dictype_data(name,typeid) values(#{name},#{typeid})")
    void saveDicTypeData(DicTypeData dicTypeData);

    /**
     * 删除类型对应的数据
     * @param typeid
     */
    @Delete("delete from t_dictype_data where typeid=#{typeid}")
    void deleteDicTypeData(Long typeid);

    /**
     * 删除类型数据
     * @param id
     */
    @Delete("delete from t_dictype where id=#{id}")
    void deleteDicType(Long id);

    /**
     * 根据类型数据id 更新数据
     * @param dicTypeData
     */
    @Update("update t_dictype_data set name=#{name} where id=#{id}")
    void editSaveDicTypeData(DicTypeData dicTypeData);

    /**
     * 根据类型数据id 删除类型数据
     * @param id
     */
    @Delete("delete from t_dictype_data where id=#{id}")
    void deleteDicTypeDataById(Long id);

    /**
     * 查询试卷等级
     * @return
     */
    @Select("select * from t_dictype_data where typeid=1")
    List<DicTypeData> findLevels();
}