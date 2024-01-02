package com.limyel.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.blog.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@TableName("post")
public class PostEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;

    private String description;

    private String content;

    private String slug;

    private Integer status;

    @TableField(exist = false)
    private List<TagEntity> tagList;

    @TableField(exist = false)
    private List<Long> tagIdList;

}
