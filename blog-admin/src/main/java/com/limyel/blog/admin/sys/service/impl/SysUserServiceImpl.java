package com.limyel.blog.admin.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.blog.admin.sys.dto.user.SysUserDTO;
import com.limyel.blog.admin.sys.dao.SysUserDao;
import com.limyel.blog.admin.sys.entity.SysUserEntity;
import com.limyel.blog.admin.sys.service.SysUserService;
import com.limyel.blog.common.pojo.PageData;
import com.limyel.blog.common.pojo.PageParam;
import com.limyel.blog.framework.mybatis.core.query.LambdaQueryWrapperPlus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao dao;

    @Override
    public PageData<SysUserEntity> page(PageParam pageParam, SysUserDTO req) {
        Page<SysUserEntity> page = new Page<>(pageParam.getPageNum(), pageParam.getPageSize());

        LambdaQueryWrapperPlus<SysUserEntity> queryWrapper = new LambdaQueryWrapperPlus<>();
        queryWrapper.likeIfPresent(SysUserEntity::getUsername, req.getUsername());
        queryWrapper.eqIfPresent(SysUserEntity::getStatus, req.getStatus());
        queryWrapper.betweenIfPresent(SysUserEntity::getCreateTime, req.getCreateTimeList());

        Page<SysUserEntity> result = dao.selectPage(page, queryWrapper);
        return new PageData<>(result.getPages(), result.getTotal(), result.getRecords());
    }
}
