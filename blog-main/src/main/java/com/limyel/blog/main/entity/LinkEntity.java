package com.limyel.blog.main.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.blog.mybatis.pojo.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 链接
 */
@Getter
@Setter
@TableName("main_link")
public class LinkEntity extends BaseEntity {

    /**
     * 名称
     */
    private String name;

    /**
     * 地址
     */
    private String url;

}
