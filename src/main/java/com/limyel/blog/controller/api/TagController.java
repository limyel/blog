package com.limyel.blog.controller.api;

import com.limyel.blog.common.api.Result;
import com.limyel.blog.entity.TagEntity;
import com.limyel.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    public Result<List<TagEntity>> list() {
        List<TagEntity> result = tagService.list();
        return Result.success(result);
    }

    @GetMapping("/{slug}")
    public Result<TagEntity> get(@PathVariable String slug) {
        TagEntity result = tagService.getBySlug(slug);
        return Result.success(result);
    }


}
