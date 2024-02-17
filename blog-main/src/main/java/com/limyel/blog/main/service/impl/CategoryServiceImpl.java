package com.limyel.blog.main.service.impl;

import com.limyel.blog.common.constant.CommonStatusEnum;
import com.limyel.blog.common.util.ConvertUtil;
import com.limyel.blog.main.dao.CategoryDao;
import com.limyel.blog.main.dataobject.CategoryDO;
import com.limyel.blog.main.service.ArticleService;
import com.limyel.blog.main.service.CategoryService;
import com.limyel.blog.main.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ArticleService articleService;

    @Override
    public List<CategoryVO> list() {
        Set<Long> ids = articleService.listCategoryId();
        List<CategoryDO> categories = categoryDao.selectBatchIds(ids);
        categories = categories.stream()
                .filter(category -> CommonStatusEnum.ENABLE.getStatus().equals(category.getStatus()))
                .collect(Collectors.toList());
        return ConvertUtil.sourceToTarget(categories, CategoryVO.class);
    }

}
