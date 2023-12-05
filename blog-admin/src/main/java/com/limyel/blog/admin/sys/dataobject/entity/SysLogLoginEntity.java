package com.limyel.blog.admin.sys.dataobject.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.blog.framework.mybatis.core.dataobject.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 登录日志
 */
@Getter
@Setter
@TableName("sys_log_login")
public class SysLogLoginEntity extends BaseEntity {

    /**
     * 用户操作，0:用户登录，1:用户退出
     */
    private Integer operation;

    /**
     * 用户代理
     */
    private String userAgent;

    /**
     * 操作IP
     */
    private String ip;

    /**
     * 状态，0:失败，1:成功，2:账号已锁定
     */
    private Integer status;

}
