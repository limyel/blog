package com.limyel.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.blog.dao.NowDao;
import com.limyel.blog.dto.NowDTO;
import com.limyel.blog.entity.NowEntity;
import com.limyel.blog.service.NowService;
import com.limyel.blog.util.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NowServiceImpl implements NowService {

    @Autowired
    private NowDao nowDao;

    @Override
    public IPage<NowDTO> list(Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<NowEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.orderByDesc(NowEntity::getCreateTime);
        Page<NowEntity> page = Page.of(pageNum, pageSize);
        nowDao.selectPage(page, queryWrapper);
        return ConvertUtil.sourceToPageTarget(page, NowDTO.class);
    }

    @Override
    public NowDTO get(Long id) {
        NowEntity now = nowDao.selectById(id);
        return ConvertUtil.sourceToTarget(now, NowDTO.class);
    }

    @Override
    public NowDTO getLatest() {
        LambdaQueryWrapper<NowEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.orderByDesc(NowEntity::getCreateTime);
        NowEntity now = nowDao.selectOne(queryWrapper);
        return ConvertUtil.sourceToTarget(now, NowDTO.class);
    }

    @Override
    public void add(NowDTO dto) {
        NowEntity now = ConvertUtil.sourceToTarget(dto, NowEntity.class);
        nowDao.insert(now);
    }

    @Override
    public void update(NowDTO dto) {
        NowEntity now = ConvertUtil.sourceToTarget(dto, NowEntity.class);
        nowDao.updateById(now);
    }

    @Override
    public void delete(Long id) {
        nowDao.deleteById(id);
    }

}
