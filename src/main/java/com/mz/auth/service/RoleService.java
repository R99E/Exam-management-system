package com.mz.auth.service;

import com.mz.auth.entity.Role;
import com.mz.auth.query.RoleQuery;
import com.mz.auth.util.PageList;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface RoleService {
    //分页查询角色
     PageList listPage(RoleQuery roleQuery);

    //保存角色
    void addRole(Role role);
    //修改保存角色
    void editRole(Role role);
    //根据id删除角色
    void deleteRole(Long id);
    //查询所有角色
    List<Role> findAllRole();

    //保存角色权限
    void saveRolePermission(Map paramMap);

    @Transactional
    void addRolePermission(Map paramMap);

    //通过用户Id查询用户角色
    List<Role> listRolesByUserid(Long id);

}