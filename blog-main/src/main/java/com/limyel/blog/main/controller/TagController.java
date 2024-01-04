package com.limyel.blog.main.controller;

import com.limyel.blog.main.service.TagService;
import com.limyel.blog.main.vo.tag.TagVO;
import com.limyel.blog.web.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/main/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    public Result<List<TagVO>> list() {
        List<TagVO> result = tagService.list();
        return Result.ok(result);
    }

    @GetMapping("/{id}")
    public Result<TagVO> get(@PathVariable Long id) {
        TagVO result = tagService.get(id);
        return Result.ok(result);
    }

}
