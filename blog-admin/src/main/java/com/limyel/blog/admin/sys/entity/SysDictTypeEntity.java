package com.limyel.blog.admin.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.blog.framework.mybatis.core.dataobject.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 字典类型
 */
@Getter
@Setter
@TableName("sys_dict_type")
public class SysDictTypeEntity extends BaseEntity {

    /**
     * 字典类型
     */
    private String dictType;

    /**
     * 字典名称
     */
    private String dictName;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 备注
     */
    private String remark;

}
