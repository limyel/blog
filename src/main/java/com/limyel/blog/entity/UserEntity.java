package com.limyel.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.blog.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("user")
public class UserEntity extends BaseEntity {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 超级管理员
     */
    private Boolean superAdmin;

}
