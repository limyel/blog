package com.limyel.blog.main.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.blog.mybatis.pojo.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 文章
 */
@Getter
@Setter
@TableName("main_post")
public class PostEntity extends BaseEntity {

    /**
     * 标题
     */
    private String title;

    /**
     * 浏览量
     */
    private Integer viewNum;

    /**
     * 内容
     */
    private String content;

    /**
     * 描述
     */
    private String description;

    /**
     * 置顶
     */
    private Boolean top;

    /**
     * 草稿
     */
    private Boolean Draft;

    /**
     * 发布时间
     */
    private LocalDateTime publishTime;

}
