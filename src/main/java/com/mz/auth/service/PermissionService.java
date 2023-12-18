package com.mz.auth.service;

import com.mz.auth.entity.Permission;

import java.util.List;

public interface PermissionService {
    //查询所有角色
    List<Permission> findAllPermission();

    public List<Permission> listAllPermission();

    //添加页面的按钮权限
    void addBtnPermission(Permission permission);

    //修改页面权限按钮
    void editBtnPermission(Permission permission);

    //根据id删除按钮权限
    void deleteBtnPermission(Long id);

    //通过用户id查询用户权限
    List<Permission> listPermissionsByUserid(Long id);
}