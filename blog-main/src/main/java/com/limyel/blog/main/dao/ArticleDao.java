package com.limyel.blog.main.dao;

import com.limyel.blog.main.dataobject.ArticleDO;
import com.limyel.blog.mybatis.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleDao extends BaseDao<ArticleDO> {
}
