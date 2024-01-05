package com.limyel.blog.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.blog.mybatis.pojo.BaseEntity;
import com.limyel.blog.security.config.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("admin")
public class AdminEntity extends BaseEntity implements UserEntity {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 备注
     */
    private String remark;

    /**
     * 关于
     */
    private String about;

}
