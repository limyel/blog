package com.limyel.blog.controller.api;

import com.limyel.blog.common.api.Result;
import com.limyel.blog.dto.SettingDTO;
import com.limyel.blog.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/setting")
public class SettingController {

    @Autowired
    private SettingService settingService;

    @GetMapping("/about")
    public Result<String> getAbout() {
        SettingDTO result = settingService.get();
        return Result.success(result.getAbout());
    }

}
