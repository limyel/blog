package com.limyel.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.blog.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@TableName("user_token")
public class UserTokenEntity extends BaseEntity implements Serializable {

    private Long userId;

    private String token;

    private Date expiredTime;

}
