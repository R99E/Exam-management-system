package com.mz.auth.web.controller;

import com.mz.auth.entity.DicType;
import com.mz.auth.entity.DicTypeData;
import com.mz.auth.query.DicQuery;
import com.mz.auth.service.DicService;
import com.mz.auth.util.MzResult;
import com.mz.auth.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @description: DicController 操作数据字典
 */
@Controller
public class DicController {

    @Autowired
    private DicService dicService;
    /**
     * 跳转数据字典 下面信息维护页面
     * @return
     */
    @GetMapping("/dic/index")
    public String index(){
        return "views/dic/dic_list";
    }

    /**
     * 查询所有的字典类型
     * @return
     */
    @PostMapping("/dic/queryDicType")
    @ResponseBody
    public List<DicType> queryDicType() {
        return dicService.queryDicType();
    }

    /**
     * 分页查询数据
     * @param dicQuery
     * @return
     */
    @GetMapping("/dic/listpage")
    @ResponseBody
    public PageList listPage(DicQuery dicQuery){
        return dicService.listPage(dicQuery);
    }

    /**
     *  根据类型id 查询对应类型数据 所有的ids集合
     */
    @PostMapping("/dic/queryDicTypeDataIdsByTypeid")
    @ResponseBody
    public List queryDicTypeDataIdsByTypeid(Long typeid){
        return dicService.queryDicTypeDataIdsByTypeid(typeid);
    }

    /**
     * 保存数据字典类型
     * @param dicType
     * @return
     */
    @PostMapping("/dic/saveDicType")
    @ResponseBody
    public MzResult saveDicType(@RequestBody DicType dicType){
        try {
            dicService.saveDicType(dicType);
            return  MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return  MzResult.error(e.getMessage());
        }
    }

    /**
     * 根据id删除类型数据
     * @param id
     * @return
     */
    @PostMapping("/dic/deleteDicType")
    @ResponseBody
    public MzResult deleteDicType(Long id){
        try {
            dicService.deleteDicType(id);
            return  MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return  MzResult.error(e.getMessage());
        }
    }


    /**
     * 保存数据字典类型对应数据
     * @param dicTypeData
     * @return
     */
    @PostMapping("/dic/saveDicTypeData")
    @ResponseBody
    public MzResult saveDicTypeData(@RequestBody DicTypeData dicTypeData){
        try {
            dicService.saveDicTypeData(dicTypeData);
            return  MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return  MzResult.error(e.getMessage());
        }
    }

    /**
     * 修改保存数据字典类型对应数据
     * @param dicTypeData
     * @return
     */
    @PostMapping("/dic/editSaveDicTypeData")
    @ResponseBody
    public MzResult editSaveDicTypeData(@RequestBody DicTypeData dicTypeData){
        try {
            dicService.editSaveDicTypeData(dicTypeData);
            return  MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return  MzResult.error(e.getMessage());
        }
    }

    /**
     * 删除类型数据
     * @param id
     * @return
     */
    @PostMapping("/dic/deleteDicTypeData")
    @ResponseBody
    public MzResult deleteDicTypeData(Long id){
        try {
            dicService.deleteDicTypeDataById(id);
            return  MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return  MzResult.error(e.getMessage());
        }
    }

    /**
     * 根据id查询类型
     * @param id
     * @return
     */
    @PostMapping("/dic/queryDicTypeInfoById")
    @ResponseBody
    public DicType queryDicTypeInfoById(Long id){
       return  dicService.queryDicTypeInfoById(id);
    }

    /**
     * 修改保存数据字典类型
     * @param dicType
     * @return
     */
    @PostMapping("/dic/editSaveDicType")
    @ResponseBody
    public MzResult editSaveDicType(@RequestBody DicType dicType){
        try {
            dicService.editSaveDicType(dicType);
            return  MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return  MzResult.error(e.getMessage());
        }
    }

}