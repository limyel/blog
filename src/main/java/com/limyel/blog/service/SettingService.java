package com.limyel.blog.service;

import com.limyel.blog.dto.SettingDTO;
import com.limyel.blog.entity.SettingEntity;

public interface SettingService {

    SettingDTO get();

    SettingEntity add(SettingDTO dto);

    void update(SettingDTO dto);

}
