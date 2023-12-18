package com.mz.auth.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: Menu菜单实体类
 * @author: 陈晓东
 * @email: 3393857689@qq.com
 */
//lombok 自动生成get set 等方法 在对应的实体类添加注解 @Data即可使用 声明所以lombok
@Data
public class Menu {

    private Long id;//菜单主键

    private String name;//菜单名称

    private String url;//菜单路径

    private String icon;//菜单图标
    //菜单父id
    private Long pid;//父id
    // 菜单父对象
    private Menu parent;//父对象
    /**
     * 子菜单 一级菜单对应多个子菜单
     */
    private List<Menu> childs = new ArrayList();
    //权限
    private Permission permission;
}