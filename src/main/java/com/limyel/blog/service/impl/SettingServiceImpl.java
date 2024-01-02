package com.limyel.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.limyel.blog.dao.SettingDao;
import com.limyel.blog.dto.SettingDTO;
import com.limyel.blog.entity.SettingEntity;
import com.limyel.blog.service.SettingService;
import com.limyel.blog.util.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingServiceImpl implements SettingService {

    @Autowired
    private SettingDao settingDao;

    @Override
    public SettingDTO get() {
        LambdaQueryWrapper<SettingEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.orderByDesc(SettingEntity::getCreateTime);
        SettingEntity setting = settingDao.selectOne(queryWrapper);
        if (setting == null) {
            setting = init();
        }
        return ConvertUtil.sourceToTarget(setting, SettingDTO.class);
    }

    @Override
    public SettingEntity add(SettingDTO dto) {
        SettingEntity setting = ConvertUtil.sourceToTarget(dto, SettingEntity.class);
        settingDao.insert(setting);
        return setting;
    }

    @Override
    public void update(SettingDTO dto) {
        SettingEntity setting = ConvertUtil.sourceToTarget(dto, SettingEntity.class);
        settingDao.updateById(setting);
    }

    private SettingEntity init() {
        SettingDTO dto = new SettingDTO();
        dto.setAbout("");
        return add(dto);
    }
}
