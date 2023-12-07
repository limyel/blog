package com.limyel.blog.admin.sys.service;

import com.limyel.blog.admin.sys.dto.user.SysUserDTO;
import com.limyel.blog.admin.sys.entity.SysUserEntity;
import com.limyel.blog.common.pojo.PageData;
import com.limyel.blog.common.pojo.PageParam;

public interface SysUserService {

    PageData<SysUserEntity> page(PageParam pageParam, SysUserDTO req);

}
