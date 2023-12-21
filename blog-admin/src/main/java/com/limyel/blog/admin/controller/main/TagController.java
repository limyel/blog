package com.limyel.blog.admin.controller.main;

import com.limyel.blog.admin.dto.main.TagDTO;
import com.limyel.blog.admin.service.main.TagService;
import com.limyel.blog.admin.vo.main.TagSimpleVO;
import com.limyel.blog.common.pojo.PageData;
import com.limyel.blog.common.pojo.PageParam;
import com.limyel.blog.common.pojo.Result;
import com.limyel.blog.security.annotation.LoginRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("adminTagController")
@RequestMapping("/admin/main/tag")
public class TagController {

    @Autowired
    private TagService service;

    @LoginRequired
    @GetMapping
    public Result<PageData<TagSimpleVO>> getPage(PageParam pageParam) {
        PageData<TagSimpleVO> result = service.getPage(pageParam);
        return Result.ok(result);
    }

    @LoginRequired
    @GetMapping("/{id}")
    public Result<TagDTO> get(@PathVariable Long id) {
        TagDTO result = service.get(id);
        return Result.ok(result);
    }

    @LoginRequired
    @PostMapping
    public Result<?> add(@RequestBody TagDTO dto) {
        service.add(dto);
        return new Result<>();
    }

    @LoginRequired
    @PutMapping
    public Result<?> update(@RequestBody TagDTO dto) {
        service.update(dto);
        return new Result<>();
    }

    @LoginRequired
    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        service.delete(id);
        return new Result<>();
    }

}
