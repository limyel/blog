package com.limyel.blog.admin.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.blog.framework.mybatis.core.dataobject.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 异常日志
 */
@Getter
@Setter
@TableName("sys_log_error")
public class SysLogErrorEntity extends BaseEntity {

    /**
     * 请求URL
     */
    private String requestUri;

    /**
     * 请求方法
     */
    private String requestMethod;

    /**
     * 请求参数
     */
    private String requestParam;

    /**
     * 用户代理
     */
    private String userAgent;

    /**
     * 操作IP
     */
    private String ip;

    /**
     * 异常信息
     */
    private String errorInfo;

}
