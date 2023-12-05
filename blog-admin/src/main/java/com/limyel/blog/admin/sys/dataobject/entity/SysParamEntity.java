package com.limyel.blog.admin.sys.dataobject.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.blog.framework.mybatis.core.dataobject.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 系统参数
 */
@Getter
@Setter
@TableName("sys_param")
public class SysParamEntity extends BaseEntity {

    /**
     * 参数编码
     */
    private String paramCode;

    /**
     * 参数值
     */
    private String paramValue;

    /**
     * 类型，0:系统参数，1:非系统参数
     */
    private Integer paramType;

    /**
     * 备注
     */
    private String remark;

}
