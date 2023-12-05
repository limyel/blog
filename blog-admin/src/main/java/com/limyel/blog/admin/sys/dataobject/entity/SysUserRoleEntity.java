package com.limyel.blog.admin.sys.dataobject.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.blog.framework.mybatis.core.dataobject.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户角色关联
 */
@Getter
@Setter
@TableName("sys_user_role")
public class SysUserRoleEntity extends BaseEntity {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;

}
