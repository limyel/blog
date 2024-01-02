package com.limyel.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.limyel.blog.dao.UserDao;
import com.limyel.blog.dto.LoginDTO;
import com.limyel.blog.dto.resp.TokenResp;
import com.limyel.blog.entity.UserEntity;
import com.limyel.blog.entity.UserTokenEntity;
import com.limyel.blog.service.UserService;
import com.limyel.blog.service.UserTokenService;
import com.limyel.blog.util.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserTokenService userTokenService;

    @Override
    public UserEntity getByToken(String token) {
        LambdaQueryWrapper<UserTokenEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(UserTokenEntity::getToken, token);
        UserTokenEntity userToken = userTokenService.getByToken(token);
        return userDao.selectById(userToken.getUserId());
    }

    @Override
    public TokenResp login(LoginDTO dto) {
        LambdaQueryWrapper<UserEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(UserEntity::getUsername, dto.getUsername());
        UserEntity userEntity = userDao.selectOne(queryWrapper);
        if (userEntity != null) {
            if (EncryptUtil.verify(userEntity.getPassword(), dto.getPassword())) {
                return userTokenService.createToken(userEntity);
            }
        }

        return null;
    }

    @Override
    public void logout(UserEntity user) {
        userTokenService.expire(user);
    }
}
