package com.limyel.blog.main.controller;

import com.limyel.blog.common.pojo.Result;
import com.limyel.blog.main.service.PostService;
import com.limyel.blog.main.service.TagService;
import com.limyel.blog.main.vo.TagDetailVO;
import com.limyel.blog.main.vo.TagSimpleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/main/tag")
public class TagController {

    @Autowired
    private TagService service;

    @GetMapping
    public Result<List<TagDetailVO>> list() {
        List<TagDetailVO> result = service.list();
        return Result.ok(result);
    }

}
