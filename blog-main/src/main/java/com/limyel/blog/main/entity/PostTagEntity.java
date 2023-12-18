package com.limyel.blog.main.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.blog.mybatis.pojo.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("main_post_tag")
public class PostTagEntity extends BaseEntity {

    /**
     * 文章ID
     */
    private Long postId;

    /**
     * 标签ID
     */
    private Long tagId;

}
