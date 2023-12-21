package com.limyel.blog.admin.controller.main;

import com.limyel.blog.admin.dto.main.AdminTagDTO;
import com.limyel.blog.admin.service.main.AdminTagService;
import com.limyel.blog.admin.vo.main.AdminTagSimpleVO;
import com.limyel.blog.common.pojo.PageData;
import com.limyel.blog.common.pojo.PageParam;
import com.limyel.blog.common.pojo.Result;
import com.limyel.blog.security.annotation.LoginRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/main/tag")
public class AdminTagController {

    @Autowired
    private AdminTagService service;

    @LoginRequired
    @GetMapping
    public Result<PageData<AdminTagSimpleVO>> getPage(PageParam pageParam) {
        PageData<AdminTagSimpleVO> result = service.getPage(pageParam);
        return Result.ok(result);
    }

    @LoginRequired
    @GetMapping("/{id}")
    public Result<AdminTagDTO> get(@PathVariable Long id) {
        AdminTagDTO result = service.get(id);
        return Result.ok(result);
    }

    @LoginRequired
    @PostMapping
    public Result<?> add(@RequestBody AdminTagDTO dto) {
        service.add(dto);
        return new Result<>();
    }

    @LoginRequired
    @PutMapping
    public Result<?> update(@RequestBody AdminTagDTO dto) {
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
