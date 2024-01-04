package com.limyel.blog.main.controller.admin;

import com.limyel.blog.main.dto.post.PostAdminDTO;
import com.limyel.blog.main.service.PostService;
import com.limyel.blog.main.vo.post.PostVO;
import com.limyel.blog.security.annotation.LoginRequired;
import com.limyel.blog.web.pojo.PageData;
import com.limyel.blog.web.pojo.PageParam;
import com.limyel.blog.web.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/post")
public class AdminPostController {

    @Autowired
    private PostService postService;

    @LoginRequired
    @GetMapping
    public Result<PageData<PostVO>> page(PageParam pageParam) {
        PageData<PostVO> result = postService.page(pageParam);
        return Result.ok(result);
    }

    @LoginRequired
    @GetMapping("/{id}")
    public Result<PostAdminDTO> get(@PathVariable Long id) {
        PostAdminDTO result = postService.adminGet(id);
        return Result.ok(result);
    }

    @LoginRequired
    @PostMapping
    public Result<?> add(@RequestBody PostAdminDTO dto) {
        postService.add(dto);
        return new Result<>();
    }

    @LoginRequired
    @PutMapping
    public Result<?> update(@RequestBody PostAdminDTO dto) {
        postService.update(dto);
        return new Result<>();
    }

    @LoginRequired
    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        postService.delete(id);
        return new Result<>();
    }

}
