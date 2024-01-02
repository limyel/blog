package com.limyel.blog.service;

import com.limyel.blog.dto.LoginDTO;
import com.limyel.blog.dto.resp.TokenResp;
import com.limyel.blog.entity.UserEntity;

public interface UserService {

    UserEntity getByToken(String token);

    TokenResp login(LoginDTO dto);

    void logout(UserEntity user);
}
