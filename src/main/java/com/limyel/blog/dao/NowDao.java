package com.limyel.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.limyel.blog.entity.NowEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NowDao extends BaseMapper<NowEntity> {
}
