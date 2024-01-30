package com.limyel.blog.main.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.blog.mybatis.pojo.BaseDO;
import lombok.Getter;
import lombok.Setter;

/**
 *
 */
@Getter
@Setter
@TableName("main_tag")
public class TagDO extends BaseDO {

    /**
     * 名称
     */
    private String name;

}
