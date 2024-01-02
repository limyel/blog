package com.limyel.blog.controller.admin;

import com.limyel.blog.common.api.Result;
import com.limyel.blog.dto.SettingDTO;
import com.limyel.blog.security.LoginRequired;
import com.limyel.blog.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sys/setting")
public class SysSettingController {

    @Autowired
    private SettingService settingService;

    @LoginRequired
    @GetMapping
    public Result<SettingDTO> get() {
        SettingDTO result = settingService.get();
        return Result.success(result);
    }

    @LoginRequired
    @PutMapping
    public Result<?> update(@RequestBody SettingDTO dto) {
        settingService.update(dto);
        return Result.success();
    }

}
