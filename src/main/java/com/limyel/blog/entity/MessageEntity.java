package com.limyel.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.blog.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@TableName("message")
public class MessageEntity extends BaseEntity implements Serializable {

    private String ip;

    private String email;

    private String nickname;

    private String content;

}
