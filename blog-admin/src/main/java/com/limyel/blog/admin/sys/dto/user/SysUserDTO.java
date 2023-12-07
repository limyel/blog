package com.limyel.blog.admin.sys.dto.user;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class SysUserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String password;

    private String avatar;

    private Integer gender;

    private String email;

    private Boolean superAdmin;

    private Integer status;

    private String remark;

    private List<Long> roleIdList;

    private LocalDateTime createTime;

    private LocalDateTime[] createTimeList;

}
