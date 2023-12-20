package com.limyel.blog.admin.controller;

import com.limyel.blog.admin.dto.AdminDTO;
import com.limyel.blog.admin.dto.LoginDTO;
import com.limyel.blog.admin.service.AdminService;
import com.limyel.blog.admin.vo.AboutVO;
import com.limyel.blog.admin.vo.SiteInfoVO;
import com.limyel.blog.admin.vo.TokenVO;
import com.limyel.blog.common.pojo.Result;
import com.limyel.blog.security.annotation.LoginRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService service;

    @GetMapping("/site-info")
    public Result<SiteInfoVO> getSiteInfo() {
        SiteInfoVO result = service.getSiteInfo();
        return Result.ok(result);
    }

    @GetMapping("/about")
    public Result<AboutVO> getAbout() {
        AboutVO result = service.getAbout();
        return Result.ok(result);
    }

    @PostMapping("/login")
    public Result<TokenVO> login(LoginDTO dto) {
        TokenVO result = service.login(dto);
        return Result.ok(result);
    }

    @LoginRequired
    @PostMapping("/logout")
    public Result<?> logout() {
        return new Result<>();
    }

    @PostMapping("/init")
    public Result<?> init(@RequestBody AdminDTO dto) {
        service.add(dto);
        return new Result<>();
    }

    @LoginRequired
    @GetMapping("/{id}")
    public Result<AdminDTO> get(@PathVariable("id") Long id) {
        AdminDTO result = service.get(id);
        return Result.ok(result);
    }

    @LoginRequired
    @PutMapping("/{id}")
    public Result<?> update(@RequestBody AdminDTO dto) {
        service.update(dto);
        return new Result<>();
    }

}
