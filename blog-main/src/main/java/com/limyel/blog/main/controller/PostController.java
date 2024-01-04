package com.limyel.blog.main.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.limyel.blog.main.dto.post.PostPageDTO;
import com.limyel.blog.main.service.PostService;
import com.limyel.blog.main.vo.post.PostArchiveVO;
import com.limyel.blog.main.vo.post.PostDetailVO;
import com.limyel.blog.main.vo.post.PostSimpleVO;
import com.limyel.blog.web.pojo.PageData;
import com.limyel.blog.web.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
// todo 根据目录匹配路由
@RequestMapping("/main/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public Result<PageData<PostSimpleVO>> page(PostPageDTO dto) {
        PageData<PostSimpleVO> result = postService.page(dto);
        return Result.ok(result);
    }

    @GetMapping("/{id}")
    public Result<PostDetailVO> get(@PathVariable Long id) {
        PostDetailVO result = postService.get(id);
        return Result.ok(result);
    }

    @GetMapping("/archive")
    public Result<Map<Integer, List<PostArchiveVO>>> archive() {
        Map<Integer, List<PostArchiveVO>> result = postService.archive();
        return Result.ok(result);
    }

}
