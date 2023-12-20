package com.limyel.blog.admin.controller.main;

import com.limyel.blog.admin.dto.main.PostDTO;
import com.limyel.blog.admin.service.main.AdminPostService;
import com.limyel.blog.admin.vo.main.PostSimpleVO;
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
    public Result<PageData<PostSimpleVO>> getPage(PageParam pageParam) {
        PageData<PostSimpleVO> result = service.getPage(pageParam);
        return Result.ok(result);
    }

    @LoginRequired
    @PostMapping
    public Result<?> add(@RequestBody PostDTO dto) {
        service.add(dto);
        return new Result<>();
    }

    @LoginRequired
    @PostMapping
    public Result<?> update(@RequestBody PostDTO dto) {
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
