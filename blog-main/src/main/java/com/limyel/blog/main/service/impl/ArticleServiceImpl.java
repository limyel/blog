package com.limyel.blog.main.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.blog.common.constant.CommonStatusEnum;
import com.limyel.blog.common.util.ConvertUtil;
import com.limyel.blog.main.dao.ArticleDao;
import com.limyel.blog.main.dataobject.ArticleDO;
import com.limyel.blog.main.service.ArticleService;
import com.limyel.blog.main.vo.ArticleHotVO;
import com.limyel.blog.mybatis.query.LambdaQueryWrapperPlus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<ArticleHotVO> listHot() {
        LambdaQueryWrapperPlus<ArticleDO> wrapperPlus = new LambdaQueryWrapperPlus<>();
        // 已发布的文章
        wrapperPlus.eqIfPresent(ArticleDO::getStatus, CommonStatusEnum.ENABLE.getStatus());
        // 按照浏览量排序
        wrapperPlus.orderByDesc(ArticleDO::getViewNum);
        // 检索前十条数据
        Page<ArticleDO> page = new Page<>(1, 10);

        articleDao.selectPage(page, wrapperPlus);
        List<ArticleDO> records = page.getRecords();

        return ConvertUtil.sourceToTarget(records, ArticleHotVO.class);
    }

    @Override
    public Set<Long> listCategoryId() {
        LambdaQueryWrapperPlus<ArticleDO> wrapperPlus = new LambdaQueryWrapperPlus<>();
        // 已发布的文章
        wrapperPlus.eqIfPresent(ArticleDO::getStatus, CommonStatusEnum.ENABLE.getStatus());
        List<ArticleDO> articles = articleDao.selectList(wrapperPlus);

        return articles.stream()
                .map(ArticleDO::getCategoryId)
                .collect(Collectors.toSet());
    }
}
