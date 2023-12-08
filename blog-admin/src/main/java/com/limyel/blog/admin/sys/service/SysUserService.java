package com.limyel.blog.admin.sys.service;

import com.limyel.blog.admin.sys.dto.user.SysUserDTO;
import com.limyel.blog.admin.sys.entity.SysUserEntity;
import com.limyel.blog.common.pojo.PageData;
import com.limyel.blog.common.pojo.PageParam;

import java.util.Collection;

public interface SysUserService {

    PageData<SysUserEntity> page(PageParam pageParam, SysUserDTO dto);

    SysUserEntity get(Long id);

    void create(SysUserDTO dto);

    void update(SysUserDTO dto);

    void delete(Long id);

    void delete(Collection<Long> ids);

}
