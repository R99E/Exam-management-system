package com.mz.auth.service.impl;

import com.mz.auth.entity.Menu;
import com.mz.auth.entity.Permission;
import com.mz.auth.mapper.MenuMapper;
import com.mz.auth.mapper.PermissionMapper;
import com.mz.auth.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description: menu业务层
 */
@Service
//1. 该注解：事务传播机制  readOnly只读
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;
    //    或者
//    @Autowired
//    private MenuMapper menuMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 根据用户id查询菜单，实现类，重写里面的方法
     * @param userid
     * @return
     */
    @Override
    public List<Menu> listMenusByUserid(Long userid) {
        return menuMapper.listMenusByUserid(userid);
    }

    /**
     * 查询所有的菜单
     */
    @Override
    public List<Menu> findAllMenus() {
        return menuMapper.findAllMenus();
    }
    /**
     * 保存一级菜单
     */
    @Override
    public void addTopMenu(Menu menu) {
        menuMapper.addTopMenu(menu);
    }

    /**
     * 保存子菜单  测试子菜单页面
     * 要保存两张表 t_menu  t_permission
     * 事务：Transaction 表示都成功才成功，如果有一个失败，就回滚
     * @param menu
     */
    @Override
    @Transactional//2.该注解说明改方法以事务方式运行
    public void addSubMenu(Menu menu) {
        //保存菜单表
        menuMapper.addSubMenu(menu);//1
        //保存权限表 t_perssion
        Permission permission = menu.getPermission();
        permission.setPid(0L);//只需要设置两个参数 t_perssion表 顶级菜单pid为0，Menuid菜单id，因为前台值传过来该t_perssion表的name title
        permission.setMenuid(menu.getId());
        permissionMapper.addPermissionMenu(permission);//2 传入参数permission
    }

    /**
     * 根据id  删除菜单
     *   (1) 先查询一级菜单 以及它的所有的子菜单
     *   (2) 如果子菜单有权限，则先 删除相应子菜单的权限
     *   (3) 然后才能删除一级菜单
     * @param id
     */
    @Override
    @Transactional//删除菜单 设计两张表，要用事务，要么全部成功，要么失败回滚
    public void deleteMenu(Long id) {
        //(1) 先查询一级菜单 以及它的所有的子菜单
        List<Menu> menus =  menuMapper.findMenuAndSubMenu(id);
        menus.forEach(menu->{//forEach循环遍历
            //(2)删除子菜单对应的权限
            permissionMapper.deleteMenuPermission(id);
            //(3)删除对应的菜单（如果是 点击二级菜单进行删除，此时二级菜单相当于一级菜单，直接删除）
            menuMapper.deleteMenuById(id);
        });

    }

    /**
     * 修改菜单
     * @param menu
     */
    @Override
    @Transactional
    public void editMenu(Menu menu) {
        menuMapper.editMenu(menu);
        /*
         * 还要更新 权限表的菜单名称title字段，否则t_menu表的name菜单名和t_permission的 title不一样，意思都是 菜单名称，所以还要更新权限表，实现同步更新
         * */
        //更新权限 更新权限表的菜单名称title字段  需要传id name参数到 sql，直接传menu对象方便，包含了这些参数
        permissionMapper.editPermissionByMenu(menu);
    }


}