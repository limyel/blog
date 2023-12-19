package com.limyel.blog.main.dao;

import com.limyel.blog.main.entity.TagEntity;
import com.limyel.blog.mybatis.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagDao extends BaseDao<TagEntity> {

    List<TagEntity> selectByPost(Long postId);

}
