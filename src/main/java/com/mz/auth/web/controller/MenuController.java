package com.mz.auth.web.controller;

import com.mz.auth.entity.Menu;
import com.mz.auth.service.MenuService;
import com.mz.auth.util.MzResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @description: MenuController菜单控制器类
 */
@Controller
public class MenuController {


    @Autowired
    private MenuService menuService;

    /**
     * 菜单的列表页
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/menu/index")
    public String index(Long id, Model model){//用model来存储menus 菜单数据
        //查询所有的菜单
        List<Menu> menus = menuService.findAllMenus();
        model.addAttribute("menus",menus);
        model.addAttribute("menuid",id);
        //返回菜单列表页
        return "views/menu/menu_list";
    }

    /**
     * 保存菜单的一级菜单 即顶级菜单
     * @param menu
     * @param
     * @return
     */
    @PostMapping("/menu/addTopMenu")//前台是post请求
    @ResponseBody
    public MzResult addTopMenu(Menu menu){
        try {
            //调用menuService层 addTopMenu方法
            menuService.addTopMenu(menu);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error("保存失败");
        }
    }

    /**
     * 保存子菜单
     * @param menu
     * @return
     */
    @PostMapping("/menu/addSubMenu")
    @ResponseBody//返回数据是json格式
    public MzResult addSubMenu(@RequestBody Menu menu){
        try {
            menuService.addSubMenu(menu);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error("保存失败");
        }
    }

    /**
     * 根据id 删除菜单
     * @param id
     * @return
     */
    @PostMapping("/menu/deleteMenu")
    @ResponseBody
    public MzResult deleteMenu(Long id){
        try {
            menuService.deleteMenu(id);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }

    /**
     * 修改菜单 思路一样的
     * @param menu
     * @return
     */
    @PostMapping("/menu/editMenu")
    @ResponseBody
    public MzResult editMenu(@RequestBody Menu menu){
        try {
            menuService.editMenu(menu);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }

}