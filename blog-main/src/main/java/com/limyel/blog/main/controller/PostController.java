package com.limyel.blog.main.controller;

import com.limyel.blog.common.pojo.PageData;
import com.limyel.blog.common.pojo.Result;
import com.limyel.blog.main.dto.PostPageDTO;
import com.limyel.blog.main.service.PostService;
import com.limyel.blog.main.vo.PostDetailVO;
import com.limyel.blog.main.vo.PostSimpleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// todo 通过目录获取路由
@RestController
@RequestMapping("/main/post")
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping
    public Result<PageData<PostSimpleVO>> getPage(PostPageDTO dto) {
        PageData<PostSimpleVO> result = service.getPage(dto);
        return Result.ok(result);
    }

    @GetMapping("/{id}")
    public Result<PostDetailVO> get(@PathVariable Long id) {
        PostDetailVO result = service.getDetail(id);
        return Result.ok(result);
    }

}
