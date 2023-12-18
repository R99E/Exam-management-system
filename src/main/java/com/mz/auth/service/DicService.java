package com.mz.auth.service;

import com.mz.auth.entity.DicType;
import com.mz.auth.entity.DicTypeData;
import com.mz.auth.query.DicQuery;
import com.mz.auth.util.PageList;

import java.util.List;

/**
 * @description:
 */
public interface DicService {
    /**
     * 查询所有的字典类型
     * @return
     */
    List<DicType> queryDicType();

    /**
     * 分页查询数据字典类型对应的数据
     * @param dicQuery
     * @return
     */
    PageList listPage(DicQuery dicQuery);

    /**
     * 根据字典类型id 查询对应的类型数据id集合
     * @param typeid
     * @return
     */
    List queryDicTypeDataIdsByTypeid(Long typeid);

    /**
     * 保存数据字典类型
     * @param dicType
     */
    void saveDicType(DicType dicType);

    /**
     * 根据id 查询字典类型
     * @param id
     * @return
     */
    DicType queryDicTypeInfoById(Long id);

    /**
     * 修改保存字典类型
     * @param dicType
     */
    void editSaveDicType(DicType dicType);

    /**
     * 新增保存类型的数据
     * @param dicTypeData
     */
    void saveDicTypeData(DicTypeData dicTypeData);

    /**
     * 删除类型数据
     * @param id
     */
    void deleteDicType(Long id);

    /**
     * 修改保存类型数据
     * @param dicTypeData
     */
    void editSaveDicTypeData(DicTypeData dicTypeData);

    /**
     * 根据类型数据id删除类型数据
     * @param id
     */
    void deleteDicTypeDataById(Long id);

    /**
     * 查询试卷等级
     * @return
     */
    List<DicTypeData> findLevels();
}