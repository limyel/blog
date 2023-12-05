package com.limyel.blog.admin.sys.controller;

import com.limyel.blog.admin.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// todo 根据目录来找路由
@RequestMapping("/sys/")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;



}
