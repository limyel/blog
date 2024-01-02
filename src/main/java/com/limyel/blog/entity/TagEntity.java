package com.limyel.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.blog.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@TableName("tag")
public class TagEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    private String slug;

    @TableField(exist = false)
    private int postNum;

}
