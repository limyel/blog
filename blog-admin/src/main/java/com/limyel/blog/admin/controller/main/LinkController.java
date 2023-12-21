package com.limyel.blog.admin.controller.main;

import com.limyel.blog.admin.dto.main.LinkDTO;
import com.limyel.blog.admin.dto.main.PostDTO;
import com.limyel.blog.admin.service.main.LinkService;
import com.limyel.blog.common.pojo.PageData;
import com.limyel.blog.common.pojo.PageParam;
import com.limyel.blog.common.pojo.Result;
import com.limyel.blog.security.annotation.LoginRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("adminLinkController")
@RequestMapping("/admin/main/link")
public class LinkController {

    @Autowired
    private LinkService service;

    @LoginRequired
    @GetMapping
    public Result<PageData<LinkDTO>> getPage(PageParam pageParam) {
        PageData<LinkDTO> result = service.getPage(pageParam);
        return Result.ok(result);
    }

    @LoginRequired
    @GetMapping("/{id}")
    public Result<LinkDTO> getPage(@PathVariable Long id) {
        LinkDTO result = service.get(id);
        return Result.ok(result);
    }

    @LoginRequired
    @PostMapping
    public Result<?> add(LinkDTO dto) {
        service.add(dto);
        return new Result<>();
    }

    @LoginRequired
    @PutMapping
    public Result<?> update(LinkDTO dto) {
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
