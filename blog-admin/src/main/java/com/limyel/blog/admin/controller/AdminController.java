package com.limyel.blog.admin.controller;

import com.limyel.blog.admin.dto.LoginDTO;
import com.limyel.blog.admin.service.AdminService;
import com.limyel.blog.admin.vo.TokenVO;
import com.limyel.blog.web.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public Result<TokenVO> login(LoginDTO dto) {
        TokenVO result = adminService.login(dto);
        return Result.ok(result);
    }

}
