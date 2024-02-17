package com.limyel.blog.main.service;

import com.limyel.blog.main.dataobject.ArticleDO;
import com.limyel.blog.main.vo.ArticleHotVO;

import java.util.List;

public interface ArticleService {

    List<ArticleHotVO> listHot();

}
