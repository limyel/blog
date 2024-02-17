package com.limyel.blog.main.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.blog.mybatis.pojo.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 分类(Category)表实体类
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("main_category")
public class CategoryDO extends BaseDO {

    /**
     * 分类名
     */
    private String name;
    
    /**
     * 父分类ID
     */
    private Long pid;
    
    /**
     * 描述
     */
    private String description;
    
    /**
     * 状态
     */
    private Integer status;
    
}

