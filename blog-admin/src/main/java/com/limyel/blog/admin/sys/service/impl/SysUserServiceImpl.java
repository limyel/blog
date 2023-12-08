package com.limyel.blog.admin.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.blog.admin.sys.convert.SysUserConvert;
import com.limyel.blog.admin.sys.dto.user.SysUserDTO;
import com.limyel.blog.admin.sys.dao.SysUserDao;
import com.limyel.blog.admin.sys.entity.SysUserEntity;
import com.limyel.blog.admin.sys.service.SysUserService;
import com.limyel.blog.common.pojo.PageData;
import com.limyel.blog.common.pojo.PageParam;
import com.limyel.blog.framework.mybatis.core.query.LambdaQueryWrapperPlus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao dao;

    @Override
    public PageData<SysUserEntity> page(PageParam pageParam, SysUserDTO dto) {
        Page<SysUserEntity> page = new Page<>(pageParam.getPageNum(), pageParam.getPageSize());

        LambdaQueryWrapperPlus<SysUserEntity> queryWrapper = new LambdaQueryWrapperPlus<>();
        queryWrapper.likeIfPresent(SysUserEntity::getUsername, dto.getUsername());
        queryWrapper.eqIfPresent(SysUserEntity::getStatus, dto.getStatus());
        queryWrapper.betweenIfPresent(SysUserEntity::getCreateTime, dto.getCreateTimeList());

        Page<SysUserEntity> result = dao.selectPage(page, queryWrapper);
        return new PageData<>(result.getPages(), result.getTotal(), result.getRecords());
    }

    @Override
    public SysUserEntity get(Long id) {
        return dao.selectById(id);
    }

    @Override
    public void create(SysUserDTO dto) {
        SysUserEntity sysUser = SysUserConvert.INSTANCE.convertToEntity(dto);

        // todo 密码加密

        dao.insert(sysUser);
    }

    @Override
    public void update(SysUserDTO dto) {
        SysUserEntity sysUser = dao.selectById(dto.getId());
        BeanUtils.copyProperties(dto, sysUser);

        dao.updateById(sysUser);
    }

    @Override
    public void delete(Long id) {
        dao.deleteById(id);
    }

    @Override
    public void delete(Collection<Long> ids) {
        dao.deleteBatchIds(ids);
    }
}
