package com.limyel.blog.admin.main.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.blog.mybatis.pojo.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 管理员
 */
@Getter
@Setter
@TableName("admin")
public class AdminEntity extends BaseEntity {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 网站标题
     */
    private String siteName;

    /**
     * 网站副标题
     */
    private String subSiteName;

    /**
     * 关于
     */
    private String about;

    /**
     * 备注
     */
    private String remark;

}
