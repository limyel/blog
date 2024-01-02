package com.limyel.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.blog.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@TableName("post_tag")
public class PostTagEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long postId;

    private Long tagId;

}
