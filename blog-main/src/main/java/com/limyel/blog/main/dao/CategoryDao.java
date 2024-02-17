package com.limyel.blog.main.dao;

import com.limyel.blog.main.dataobject.CategoryDO;
import com.limyel.blog.mybatis.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryDao extends BaseDao<CategoryDO> {
}
