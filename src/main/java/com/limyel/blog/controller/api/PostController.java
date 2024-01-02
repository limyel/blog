package com.limyel.blog.controller.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.limyel.blog.common.api.Result;
import com.limyel.blog.dto.PostDTO;
import com.limyel.blog.entity.PostEntity;
import com.limyel.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public Result<IPage<?>> list(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize,
            PostDTO dto) {
        IPage<PostEntity> result = postService.list(pageNum, pageSize, dto);
        return Result.success(result);
    }

    @GetMapping("/archive")
    public Result<?> archive() {
        Map<Integer, List<PostEntity>> result = postService.archive();
        return Result.success(result);
    }

    @GetMapping("/{slug}")
    public Result<PostEntity> get(@PathVariable String slug) {
        PostEntity result = postService.getBySlug(slug);
        return Result.success(result);
    }

}
