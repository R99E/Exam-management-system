package com.mz.auth.web.controller;

import com.mz.auth.entity.Permission;
import com.mz.auth.entity.Role;
import com.mz.auth.query.RoleQuery;
import com.mz.auth.service.PermissionService;
import com.mz.auth.service.RoleService;
import com.mz.auth.util.MzResult;
import com.mz.auth.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class RoleController {
	//跳转角色列表页方法


    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/role/index")
    public String index(Long id, Model model){
        model.addAttribute("menuid",id);
        //查询所有权限
        List<Permission> permissions = permissionService.findAllPermission();
        model.addAttribute("permissions",permissions);

        return "views/role/role_list";
    }

    @Autowired
    private RoleService roleService;

    @GetMapping("/role/listpage")
    @ResponseBody
    public PageList listPage(RoleQuery roleQuery){
        return roleService.listPage(roleQuery);
    }

    //保存角色
    @PostMapping("/role/addRole")
    @ResponseBody
    public MzResult addRole(Role role){
        try {
            roleService.addRole(role);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }

    //修改保存角色
    @PostMapping("/role/editSaveRole")
    @ResponseBody
    public MzResult editRole(Role role){
        try {
            roleService.editRole(role);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }
    //删除角色
    @GetMapping("/role/deleteRole")
    @ResponseBody
    public MzResult deleteRole(Long id){
        try {
            roleService.deleteRole(id);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }

    //保存角色对应权限
    @PostMapping("/role/addRolePermission")
    @ResponseBody
    public MzResult addRolePermission(@RequestBody Map paramMap){
        try {
            roleService.addRolePermission(paramMap);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }

}