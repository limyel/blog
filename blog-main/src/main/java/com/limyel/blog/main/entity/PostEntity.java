package com.limyel.blog.main.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.blog.main.vo.tag.TagVO;
import com.limyel.blog.mybatis.pojo.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

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
     * 是否可评论
     */
    private Boolean comment;

    /**
     * 草稿
     */
    private Boolean draft;

    /**
     * 发布时间
     */
    private LocalDateTime publishTime;


    @TableField(exist = false)
    private List<TagVO> tags;

    @TableField(exist = false)
    private Long commentNum;

}
