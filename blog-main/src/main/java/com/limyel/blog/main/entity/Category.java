package com.limyel.blog.main.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 分类(Category)表实体类
 *
 * @author makejava
 * @since 2024-02-17 22:19:51
 */
@Data
@TableName("main_category")
public class Category {

    /**
     * ID
     */
    private Long id;
    
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
    
    /**
     * 创建者
     */
    private Long createBy;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 更新者
     */
    private Long updateBy;
    
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    
    /**
     * 删除时间
     */
    private LocalDateTime deleteTime;
    
}

