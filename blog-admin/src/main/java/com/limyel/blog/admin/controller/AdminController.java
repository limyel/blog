package com.limyel.blog.admin.controller;

import com.limyel.blog.admin.dto.AboutDTO;
import com.limyel.blog.admin.dto.LoginDTO;
import com.limyel.blog.admin.service.AdminService;
import com.limyel.blog.admin.vo.TokenVO;
import com.limyel.blog.security.annotation.LoginRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 */
@RestController
@RequestMapping("/sys/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public Result<TokenVO> login(LoginDTO dto) {
        TokenVO result = adminService.login(dto);
        return Result.ok(result);
    }

    @GetMapping("/about")
    public Result<String> getAbout() {
        String result = adminService.getAbout();
        return Result.ok(result);
    }

    @LoginRequired
    @GetMapping("/sys-about")
    public Result<String> getSysAbout() {
        String result = adminService.getSysAbout();
        return Result.ok(result);
    }

    @LoginRequired
    @PutMapping("/about")
    public Result<?> updateAbout(@RequestBody AboutDTO dto) {
        adminService.updateAbout(dto);
        return new Result<>();
    }

}
