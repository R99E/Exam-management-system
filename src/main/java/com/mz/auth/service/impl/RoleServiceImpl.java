package com.mz.auth.service.impl;

import com.mz.auth.entity.Role;
import com.mz.auth.mapper.RoleMapper;
import com.mz.auth.query.RoleQuery;
import com.mz.auth.service.RoleService;
import com.mz.auth.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    //分页查询角色
    @Override
    public PageList listPage(RoleQuery roleQuery) {
        PageList pageList = new PageList();
        pageList.setTotal(roleMapper.queryTotal(roleQuery));
        pageList.setRows(roleMapper.queryData(roleQuery));
        return pageList;
    }
    //保存角色
    @Override
    public void addRole(Role role) {
        roleMapper.addRole(role);
    }

    //修改保存操作
    @Override
    public void editRole(Role role) {
        roleMapper.editRole(role);

    }
    /**
     *根据id删除角色
     *  1 角色对应的权限中间件表t_role_permission 关联数据
     *  2 删除角色表 t_role
     */
    @Override
    @Transactional
    public void deleteRole(Long id) {
        roleMapper.deleteRolePermission(id);
        roleMapper.deleteRole(id);
    }
    //查询所有角色
    @Override
    public List<Role> findAllRole() {
        return roleMapper.findAllRole();
    }

    @Override
    public void saveRolePermission(Map paramMap) {

    }

    @Override
    @Transactional
    public void addRolePermission(Map paramMap) {
        Long roleId = Long.parseLong((String)paramMap.get("roleId"));
        List pids =  (List)paramMap.get("permissionIds");
        //（1） 先在中间表 删除角色对应的权限
        roleMapper.deleteRolePermission(roleId);
        // (2) 在插入中间表 批量插入操作
        List<Map> paramList = new ArrayList();
        pids.forEach(pid->{
            Map mp = new HashMap();
            mp.put("roleId",roleId);
            mp.put("permissionId",pid);
            paramList.add(mp);
        });
        //批量保存中间表数据
        roleMapper.addRolePermission(paramList);
    }

    //根据用户id查询角色
    @Override
    public List<Role> listRolesByUserid(Long userid) {
        return roleMapper.listRolesByUserid(userid);
    }
}