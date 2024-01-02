package com.limyel.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.limyel.blog.dao.UserTokenDao;
import com.limyel.blog.dto.resp.TokenResp;
import com.limyel.blog.entity.UserEntity;
import com.limyel.blog.entity.UserTokenEntity;
import com.limyel.blog.security.TokenGenerator;
import com.limyel.blog.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserTokenServiceImpl implements UserTokenService {

    private final static int EXPIRE = 3600 * 12;

    @Autowired
    private UserTokenDao userTokenDao;

    @Override
    public UserTokenEntity getByUserId(Long userId) {
        LambdaQueryWrapper<UserTokenEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(UserTokenEntity::getUserId, userId);
        return userTokenDao.selectOne(queryWrapper);
    }

    @Override
    public UserTokenEntity getByToken(String token) {
        LambdaQueryWrapper<UserTokenEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(UserTokenEntity::getToken, token);
        return userTokenDao.selectOne(queryWrapper);
    }

    @Override
    public void expire(UserEntity user) {
        Date now = new Date();
        UserTokenEntity userToken = getByUserId(user.getId());
        if (!checkExpired(userToken)) {
            return;
        }
        userToken.setExpiredTime(now);
        userTokenDao.updateById(userToken);
    }

    @Override
    public TokenResp createToken(UserEntity user) {
        String token;
        Date now = new Date();
        Date expiredTime = new Date(now.getTime() + EXPIRE * 1000);
        UserTokenEntity userToken = getByUserId(user.getId());
        if (userToken == null) {
            token = TokenGenerator.generateValue();
            userToken = new UserTokenEntity();
            userToken.setUserId(user.getId());
            userToken.setExpiredTime(expiredTime);
            userToken.setToken(token);

            userTokenDao.insert(userToken);
        } else {
            if (userToken.getExpiredTime().getTime() < now.getTime()) {
                token = TokenGenerator.generateValue();
            } else {
                token = userToken.getToken();
            }
            userToken.setToken(token);
            userToken.setExpiredTime(expiredTime);

            userTokenDao.updateById(userToken);
        }

        TokenResp result = new TokenResp();
        result.setToken(token);
        result.setExpiredTime(expiredTime);
        return result;
    }

    private boolean checkExpired(UserTokenEntity userToken) {
        return userToken != null && userToken.getExpiredTime().getTime() > System.currentTimeMillis();
    }
}
