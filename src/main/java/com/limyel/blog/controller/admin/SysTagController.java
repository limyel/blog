package com.limyel.blog.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.limyel.blog.common.api.Result;
import com.limyel.blog.dto.TagDTO;
import com.limyel.blog.entity.TagEntity;
import com.limyel.blog.security.LoginRequired;
import com.limyel.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sys/tag")
public class SysTagController {

    @Autowired
    private TagService tagService;

    @LoginRequired
    @GetMapping
    public Result<IPage<TagEntity>> list(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize) {
        IPage<TagEntity> result = tagService.list(pageNum, pageSize);
        return Result.success(result);
    }

    @LoginRequired
    @GetMapping("/all")
    public Result<List<TagEntity>> all() {
        List<TagEntity> result = tagService.all();
        return Result.success(result);
    }

    @LoginRequired
    @GetMapping("/{id}")
    public Result<TagDTO> get(@PathVariable Long id) {
        TagDTO result = tagService.get(id);
        return Result.success(result);
    }

    @LoginRequired
    @PostMapping
    public Result<?> add(@RequestBody TagDTO dto) {
        tagService.add(dto);
        return Result.success();
    }

    @LoginRequired
    @PutMapping
    public Result<?> update(@RequestBody TagDTO dto) {
        tagService.update(dto);
        return Result.success();
    }

    @LoginRequired
    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        tagService.delete(id);
        return Result.success();
    }

}
