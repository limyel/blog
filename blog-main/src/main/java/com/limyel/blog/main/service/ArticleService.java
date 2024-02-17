package com.limyel.blog.main.service;

import com.limyel.blog.main.vo.ArticleHotVO;

import java.util.List;
import java.util.Set;

public interface ArticleService {

    List<ArticleHotVO> listHot();

    Set<Long> listCategoryId();

}
