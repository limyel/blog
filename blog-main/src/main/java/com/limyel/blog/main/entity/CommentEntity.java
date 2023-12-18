package com.limyel.blog.main.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.blog.mybatis.pojo.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 评论
 */
@Getter
@Setter
@TableName("main_comment")
public class CommentEntity extends BaseEntity {

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 文章ID
     */
    private Long postId;

    /**
     * 上级评论ID
     */
    private Long pid;

    /**
     * 内容
     */
    private String content;

    /**
     * 是否为admin评论
     */
    private Boolean admin;

    /**
     * 状态，0:待审核，1:审核通过，2:审核不通过
     */
    private Integer status;

}
