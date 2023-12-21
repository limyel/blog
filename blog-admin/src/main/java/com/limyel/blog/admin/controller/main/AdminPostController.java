package com.limyel.blog.admin.controller.main;

import com.limyel.blog.admin.dto.main.AdminPostDTO;
import com.limyel.blog.admin.service.main.AdminPostService;
import com.limyel.blog.admin.vo.main.AdminPostSimpleVO;
import com.limyel.blog.common.pojo.PageData;
import com.limyel.blog.common.pojo.PageParam;
import com.limyel.blog.common.pojo.Result;
import com.limyel.blog.security.annotation.LoginRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/main/post")
public class AdminPostController {

    @Autowired
    private AdminPostService service;

    @LoginRequired
    @GetMapping
    public Result<PageData<AdminPostSimpleVO>> getPage(PageParam pageParam) {
        PageData<AdminPostSimpleVO> result = service.getPage(pageParam);
        return Result.ok(result);
    }

    @LoginRequired
    @GetMapping("/{id}")
    public Result<AdminPostDTO> get(@PathVariable Long id) {
        AdminPostDTO result = service.get(id);
        return Result.ok(result);
    }

    @LoginRequired
    @PostMapping
    public Result<?> add(@RequestBody AdminPostDTO dto) {
        service.add(dto);
        return new Result<>();
    }

    @LoginRequired
    @PostMapping
    public Result<?> update(@RequestBody AdminPostDTO dto) {
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
