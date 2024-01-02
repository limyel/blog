package com.limyel.blog.service;

import com.limyel.blog.dto.resp.TokenResp;
import com.limyel.blog.entity.UserEntity;
import com.limyel.blog.entity.UserTokenEntity;

public interface UserTokenService {

    UserTokenEntity getByUserId(Long userId);

    UserTokenEntity getByToken(String token);

    void expire(UserEntity user);

    TokenResp createToken(UserEntity user);

}
