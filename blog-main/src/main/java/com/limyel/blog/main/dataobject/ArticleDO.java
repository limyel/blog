package com.limyel.blog.main.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.blog.mybatis.pojo.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 文章(Article)表实体类
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("main_article")
public class ArticleDO extends BaseDO {

    /**
     * 标题
     */
    private String title;
    
    /**
     * 内容
     */
    private String content;
    
    /**
     * 摘要
     */
    private String summary;
    
    /**
     * 所属分类ID
     */
    private Long categoryId;
    
    /**
     * 置顶
     */
    private Boolean top;
    
    /**
     * 状态
     */
    private Integer status;
    
    /**
     * 浏览量
     */
    private Integer viewNum;
    
    /**
     * 是否可评论
     */
    private Boolean comment;
    
    /**
     * 发布时间
     */
    private LocalDateTime publishTime;

}

