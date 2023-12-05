package com.limyel.blog.admin.sys.dataobject.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.blog.framework.mybatis.core.dataobject.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 字典数据
 */
@Getter
@Setter
@TableName("sys_dict_data")
public class SysDictDataEntity extends BaseEntity {

    /**
     * 字典ID
     */
    private Long dictTypeId;

    /**
     * 字典名称
     */
    private String dictLabel;

    /**
     * 字典值
     */
    private String dictValue;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 备注
     */
    private String remark;

}
