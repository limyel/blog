package com.limyel.blog.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.limyel.blog.common.api.Result;
import com.limyel.blog.dto.PostDTO;
import com.limyel.blog.entity.PostEntity;
import com.limyel.blog.security.LoginRequired;
import com.limyel.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sys/post")
public class SysPostController {

    @Autowired
    private PostService postService;

    @LoginRequired
    @GetMapping
    public Result<IPage<PostEntity>> list(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize) {
        IPage<PostEntity> result = postService.all(pageNum, pageSize);
        return Result.success(result);
    }

    @LoginRequired
    @GetMapping("/{id}")
    public Result<PostEntity> get(@PathVariable Long id) {
        PostEntity result = postService.get(id);
        return Result.success(result);
    }

    @LoginRequired
    @PostMapping
    public Result<?> add(@RequestBody PostDTO dto) {
        postService.add(dto);
        return Result.success();
    }

    @LoginRequired
    @PutMapping
    public Result<?> update(@RequestBody PostDTO dto) {
        postService.update(dto);
        return Result.success();
    }

    @LoginRequired
    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        postService.delete(id);
        return Result.success();
    }
}
