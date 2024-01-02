package com.limyel.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.blog.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@TableName("now")
public class NowEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String content;

}
