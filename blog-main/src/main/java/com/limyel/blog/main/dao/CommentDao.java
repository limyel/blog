package com.limyel.blog.main.dao;

import com.limyel.blog.main.entity.CommentEntity;
import com.limyel.blog.mybatis.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentDao extends BaseDao<CommentEntity> {
}
