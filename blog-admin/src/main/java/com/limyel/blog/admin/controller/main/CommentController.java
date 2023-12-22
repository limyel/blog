package com.limyel.blog.admin.controller.main;

import com.limyel.blog.admin.dto.main.CommentStatusDTO;
import com.limyel.blog.admin.dto.main.PostDTO;
import com.limyel.blog.admin.service.main.CommentService;
import com.limyel.blog.admin.service.main.PostService;
import com.limyel.blog.admin.vo.main.CommentVO;
import com.limyel.blog.admin.vo.main.PostSimpleVO;
import com.limyel.blog.common.pojo.PageData;
import com.limyel.blog.common.pojo.PageParam;
import com.limyel.blog.common.pojo.Result;
import com.limyel.blog.security.annotation.LoginRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("adminCommentController")
@RequestMapping("admin/main/comment")
public class CommentController {

    @Autowired
    private CommentService service;

    @Autowired
    private PostService postService;

    @LoginRequired
    @GetMapping
    public Result<PageData<CommentVO>> getPage(PageParam pageParam) {
        PageData<CommentVO> result = service.getPage(pageParam);

        result.getList().forEach(item -> {
            PostDTO postDTO = postService.get(item.getId());
            PostSimpleVO post = new PostSimpleVO();
            post.setId(postDTO.getId());
            post.setTitle(postDTO.getTitle());
            item.setPost(post);
        });

        return Result.ok(result);
    }

    @LoginRequired
    @PutMapping
    public Result<?> updateStatus(@RequestBody CommentStatusDTO dto) {
        service.updateStatus(dto);
        return new Result<>();
    }

    @LoginRequired
    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        service.delete(id);
        return new Result<>();
    }

}
