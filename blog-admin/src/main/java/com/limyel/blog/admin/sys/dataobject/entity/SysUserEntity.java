package com.limyel.blog.admin.sys.dataobject.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.blog.framework.mybatis.core.dataobject.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 系统用户
 */
@Getter
@Setter
@TableName("sys_user")
public class SysUserEntity extends BaseEntity {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 性别，0：男，1：女，2：保密
     */
    private Integer gender;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 是否是超级管理员
     */
    private Boolean superAdmin;

    /**
     * 状态，0：停用，1：正常
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

}
