package com.mz.auth.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @description:Log
 */
@Data
public class Log {
   
    private Long id;//主键id
    
    private String url;//请求路径
    
    private String http_method;//请求方式
    
    private String ip;//ip地址
   
    private String class_method;//操作和类名和方法
   
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;//日志生成时间
   
    private Long userid;//操作用户
  
    private User user;//操作用户对象

}