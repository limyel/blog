package com.limyel.blog.admin.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.blog.framework.mybatis.core.dataobject.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 操作日志
 */
@Getter
@Setter
@TableName("sys_log_operation")
public class SysLogOperationEntity extends BaseEntity {

    /**
     * 用户操作
     */
    private String operation;

    /**
     * 请求模块
     */
    private String module;

    /**
     * 请求URI
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
     * 请求时长（毫秒）
     */
    private Integer requestTime;

    /**
     * 用户代理
     */
    private String userAgent;

    /**
     * 操作IP
     */
    private String ip;

    /**
     * 响应结果
     */
    private String result;

    /**
     * 状态，0:失败，1:成功
     */
    private Integer status;

}
