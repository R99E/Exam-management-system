package com.mz.auth.mapper;

import com.mz.auth.entity.Role;
import com.mz.auth.query.RoleQuery;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface RoleMapper {
    //查找总的条数
    Long queryTotal(RoleQuery roleQuery);
    //分页的数据
    List queryData(RoleQuery roleQuery);

    //保存角色
    @Insert("insert into t_role(name,`desc`) values(#{name},#{desc})")
    void addRole(Role role);

    //修改保存操作
    @Update("update t_role set name=#{name},`desc`=#{desc} where id=#{id}")
    void editRole(Role role);

    //删除角色
    @Delete("delete from t_role where id=#{id}")
    void deleteRole(Long id);

    //删除角色对应的权限
    @Delete("delete from t_role_permission where roleid=#{id}")
    void deleteRolePermission(Long id);

    //查询所有的角色
    @Select("select * from t_role")
    List<Role> findAllRole();

    void saveRolePermission(List<Map> paramList);

    //批量插入角色权限中间表
    @Insert("<script>" +
            "insert into t_role_permission (roleid,permissionid) values" +
            "<foreach collection='list' item='item'  separator=',' >" +
            "(#{item.roleId},#{item.permissionId})" +
            "</foreach>"+
            "</script>")
    void addRolePermission(List<Map> paramList);



    @Select("SELECT r.*\n" +
            "from t_role r\n" +
            "join t_user_role ur on r.id = ur.roleid\n" +
            "where ur.userid = #{userid}")
    List<Role> listRolesByUserid(Long userid);
}