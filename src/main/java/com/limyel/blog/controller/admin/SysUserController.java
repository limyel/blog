package com.limyel.blog.controller.admin;

import com.limyel.blog.common.api.Result;
import com.limyel.blog.common.constant.BlogConstant;
import com.limyel.blog.dto.LoginDTO;
import com.limyel.blog.dto.resp.TokenResp;
import com.limyel.blog.entity.UserEntity;
import com.limyel.blog.service.UserService;
import com.limyel.blog.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result<?> login(@RequestBody LoginDTO dto) {
        TokenResp result = userService.login(dto);
        return Result.success(result);
    }

    @GetMapping("/logout")
    public Result<?> logout() {
        UserEntity user = (UserEntity) ThreadLocalUtil.get(BlogConstant.CURRENT_USER);
        userService.logout(user);
        return Result.success();
    }

}
