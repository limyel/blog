package com.limyel.blog.main.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.limyel.blog.common.pojo.PageData;
import com.limyel.blog.common.pojo.Result;
import com.limyel.blog.main.convert.PostConvert;
import com.limyel.blog.main.dto.PostPageDTO;
import com.limyel.blog.main.entity.PostEntity;
import com.limyel.blog.main.service.CommentService;
import com.limyel.blog.main.service.PostService;
import com.limyel.blog.main.service.TagService;
import com.limyel.blog.main.vo.PostSimpleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

// todo 通过目录获取路由
@RestController
@RequestMapping("/main/post")
public class PostController {

    @Autowired
    private PostService service;

    @Autowired
    private TagService tagService;

    @Autowired
    private CommentService commentService;

    @GetMapping
    public Result<PageData<PostSimpleVO>> getPage(PostPageDTO dto) {
        PageData<PostSimpleVO> result = service.getPage(dto);
        result.getList().forEach(item -> {
            item.setTags(tagService.listByPost(item.getId()));
            item.setCommentNum(commentService.countByPost(item.getId()));
        });
        return Result.ok(result);
    }

}
