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
@TableName("sys_oss")
public class SysOssEntity extends BaseEntity {

    /**
     * URL地址
     */
    private String url;

}
