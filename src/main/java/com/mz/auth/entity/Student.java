package com.mz.auth.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private Long id;//主键id
    private String username;//用户名
    private String password;//密码
    private String tel;//电话号码
    private String email;//邮件
    private String stuNum;//学号
    private Date createTime;//创建时间
    private String nickName;//昵称
    private String usercode;//验证码
}