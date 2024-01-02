package com.limyel.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.limyel.blog.entity.SettingEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SettingDao extends BaseMapper<SettingEntity> {
}
