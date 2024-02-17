package com.limyel.blog.main.controller;

import com.limyel.blog.main.dataobject.ArticleDO;
import com.limyel.blog.main.service.ArticleService;
import com.limyel.blog.main.vo.ArticleHotVO;
import com.limyel.blog.web.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/main/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/hot")
    public Result<List<ArticleHotVO>> listHot() {
        List<ArticleHotVO> result = articleService.listHot();
        return Result.ok(result);
    }

}
