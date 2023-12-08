package com.limyel.blog.admin.sys.controller.user;

import com.limyel.blog.admin.sys.convert.SysUserConvert;
import com.limyel.blog.admin.sys.dto.user.SysUserDTO;
import com.limyel.blog.admin.sys.entity.SysUserEntity;
import com.limyel.blog.admin.sys.service.SysUserService;
import com.limyel.blog.admin.sys.vo.user.SysUserVO;
import com.limyel.blog.common.pojo.PageData;
import com.limyel.blog.common.pojo.PageParam;
import com.limyel.blog.common.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
// todo 根据目录来找路由
@RequestMapping("/sys/user")
public class SysUserController {

    @Autowired
    private SysUserService service;

    @GetMapping("page")
    public Result<PageData<SysUserVO>> page(@Validated PageParam pageParam, SysUserDTO dto) {
        PageData<SysUserEntity> page = service.page(pageParam, dto);

        List<SysUserVO> list = page.getList().stream().map(SysUserConvert.INSTANCE::convertToVO).collect(Collectors.toList());

        return Result.ok(new PageData<>(page, list));
    }

    @GetMapping("{id}")
    public Result<SysUserVO> get(@PathVariable("id") Long id) {
        SysUserEntity sysUser = service.get(id);

        return Result.ok(SysUserConvert.INSTANCE.convertToVO(sysUser));
    }

    @PostMapping
    public Result<?> create(SysUserDTO dto) {
        service.create(dto);
        return new Result<>();
    }

    @PutMapping
    public Result<?> update(SysUserDTO dto) {
        service.update(dto);
        return new Result<>();
    }

    @DeleteMapping
    public Result<?> delete(@RequestParam Long[] ids) {
        service.delete(Arrays.asList(ids));
        return new Result<>();
    }

}
