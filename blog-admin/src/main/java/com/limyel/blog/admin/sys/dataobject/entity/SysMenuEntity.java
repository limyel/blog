package com.limyel.blog.admin.sys.dataobject.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.blog.framework.mybatis.core.dataobject.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 系统菜单
 */
@Getter
@Setter
@TableName("sys_menu")
public class SysMenuEntity extends BaseEntity {

    /**
     * 上级菜单，一级菜单为0
     */
    private Long pid;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单路由
     */
    private String path;

    /**
     * 权限标识，多个用逗号隔开
     */
    private String permission;

    /**
     * 类型，0：菜单，1：按钮
     */
    private Integer type;

    /**
     * 图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否可见
     */
    private Boolean visible;

}
