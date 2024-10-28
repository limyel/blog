package com.limyel.blog.controller;

import com.limyel.blog.service.ArticleService;
import com.limyel.blog.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class BlogPageController {

    private final ArticleService articleService;

    private final TagService tagService;

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");

        return mv;
    }

}
