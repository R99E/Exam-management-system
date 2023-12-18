package com.mz.auth.service.impl;

import com.mz.auth.entity.DicType;
import com.mz.auth.entity.DicTypeData;
import com.mz.auth.entity.Paper;
import com.mz.auth.mapper.DicMapper;
import com.mz.auth.query.DicQuery;
import com.mz.auth.query.PaperQuery;
import com.mz.auth.service.DicService;
import com.mz.auth.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description: DicServiceImpl
 */
@Service
public class DicServiceImpl implements DicService {

    @Autowired
    private DicMapper dicMapper;

    /**
     * 查询数据字典类型
     * @return
     */
    @Override
    public List<DicType> queryDicType() {
        return dicMapper.queryDicType();
    }

    /**
     * 分页查询数据
     * @param dicQuery
     * @return
     */
    @Override
    public PageList listPage(DicQuery dicQuery) {
        PageList pageList = new PageList();
        //查询总的条数
        Long total = dicMapper.queryTotal(dicQuery);
        pageList.setTotal(total);
        //查询每页的数据
        List<DicTypeData> dicTypeDatas =  dicMapper.queryData(dicQuery);
        pageList.setRows(dicTypeDatas);
        return pageList;
    }

    /**
     * 根据类型id 查询数据字典类型数据id的集合
     * @param typeid
     * @return
     */
    @Override
    public List queryDicTypeDataIdsByTypeid(Long typeid) {
        return dicMapper.queryDicTypeDataIdsByTypeid(typeid);
    }

    /**
     * 保存数据字典类型
     * @param dicType
     */
    @Override
    public void saveDicType(DicType dicType) {
        dicMapper.saveDicType(dicType);
    }

    /**
     * 根据id查询字典类型
     * @param id
     * @return
     */
    @Override
    public DicType queryDicTypeInfoById(Long id) {
        return dicMapper.queryDicTypeInfoById(id);
    }

    /**
     * 修改保存字典类型
     * @param dicType
     */
    @Override
    public void editSaveDicType(DicType dicType) {
        dicMapper.editSaveDicType(dicType);
    }

    /**
     * 新增保存类型数据
     * @param dicTypeData
     */
    @Override
    public void saveDicTypeData(DicTypeData dicTypeData) {
        dicMapper.saveDicTypeData(dicTypeData);
    }

    /**
     * 删除类型的数据
     * @param id
     */
    @Override
    @Transactional
    public void deleteDicType(Long id) {
        dicMapper.deleteDicTypeData(id);
        dicMapper.deleteDicType(id);
    }

    /**
     * 修改保存类型数据
     * @param dicTypeData
     */
    @Override
    public void editSaveDicTypeData(DicTypeData dicTypeData) {
        dicMapper.editSaveDicTypeData(dicTypeData);
    }

    /**
     * 通过类型数据id 删除类型数据
     * @param id
     */
    @Override
    public void deleteDicTypeDataById(Long id) {
        dicMapper.deleteDicTypeDataById(id);
    }

    /**
     * 查询试卷等级
     * @return
     */
    @Override
    public List<DicTypeData> findLevels() {
        return dicMapper.findLevels();
    }
}