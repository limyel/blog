package com.limyel.blog.main.controller.admin;

import com.limyel.blog.main.convert.TagConvert;
import com.limyel.blog.main.dto.tag.TagAdminDTO;
import com.limyel.blog.main.service.TagService;
import com.limyel.blog.main.vo.tag.TagVO;
import com.limyel.blog.security.annotation.LoginRequired;
import com.limyel.blog.web.pojo.PageData;
import com.limyel.blog.web.pojo.PageParam;
import com.limyel.blog.web.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/tag")
public class AdminTagController {

    @Autowired
    private TagService tagService;

    @LoginRequired
    @GetMapping
    public Result<PageData<TagVO>> page(PageParam pageParam) {
        PageData<TagVO> result = tagService.page(pageParam);
        return Result.ok(result);
    }

    @LoginRequired
    @GetMapping("/all")
    public Result<List<TagVO>> all() {
        List<TagVO> result = tagService.all();
        return Result.ok(result);
    }

    @LoginRequired
    @GetMapping("/{id}")
    public Result<TagAdminDTO> get(@PathVariable Long id) {
        TagVO vo = tagService.get(id);
        TagAdminDTO result = TagConvert.INSTANCE.toDTO(vo);
        return Result.ok(result);
    }

    @LoginRequired
    @PostMapping
    public Result<?> add(@RequestBody TagAdminDTO dto) {
        tagService.add(dto);
        return new Result<>();
    }

    @LoginRequired
    @PutMapping
    public Result<?> update(@RequestBody TagAdminDTO dto) {
        tagService.update(dto);
        return new Result<>();
    }

    @LoginRequired
    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        tagService.delete(id);
        return new Result<>();
    }

}
