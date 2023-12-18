package com.mz.auth.service;

import com.mz.auth.entity.User;
import com.mz.auth.query.UserQuery;
import com.mz.auth.util.PageList;

import java.util.Map;

public interface UserService {
    //分页查询用户
    PageList listPage(UserQuery userQuery);

    Long addUser(User user);

    void editUser(User user);

    //根据id删除数据
    void deleteUser(Long id);

    //批量删除
    void deleteBatchUser(Long[] ids);

    //保存用户角色
    void saveUserRole(Map paramMap);

    //据用户名查询用户
    User findUserByUsername(String username);



    void updateHeadImgByUser(User user);

    //老师注册
    Long addTeacher(User user);


}