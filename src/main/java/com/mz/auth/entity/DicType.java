package com.mz.auth.entity;

import lombok.Data;

/**
 * @description: DicType 数据字典类型
 */
@Data
public class DicType {
 
    private Long id;//字典类型主键
   
    private String sn;//类型编号 level
 
    private String info;//类型名称
}