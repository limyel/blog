package com.limyel.blog.admin.controller;

import com.limyel.blog.admin.service.AdminService;
import com.limyel.blog.admin.vo.AboutVO;
import com.limyel.blog.admin.vo.SiteInfoVO;
import com.limyel.blog.common.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/site-info")
    public Result<SiteInfoVO> getSiteInfo() {
        SiteInfoVO result = adminService.getSiteInfo();
        return Result.ok(result);
    }

    @GetMapping("/about")
    public Result<AboutVO> getAbout() {
        AboutVO result = adminService.getAbout();
        return Result.ok(result);
    }

}
