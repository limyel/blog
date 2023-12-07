package com.limyel.blog.admin.sys.controller.user;

import com.limyel.blog.admin.sys.dto.user.SysUserDTO;
import com.limyel.blog.admin.sys.service.SysUserService;
import com.limyel.blog.admin.sys.vo.user.SysUserVO;
import com.limyel.blog.common.pojo.PageData;
import com.limyel.blog.common.pojo.PageParam;
import com.limyel.blog.common.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// todo 根据目录来找路由
@RequestMapping("/sys/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/page")
    public Result<PageData<SysUserVO>> page(SysUserDTO req, @Validated PageParam pageParam) {

        return null;
    }



}
