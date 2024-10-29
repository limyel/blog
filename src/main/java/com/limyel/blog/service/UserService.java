package com.limyel.blog.service;

import com.limyel.blog.dao.UserReposiroty;
import com.limyel.blog.model.entity.UserEntity;
import com.limyel.blog.util.CryptUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserReposiroty userReposiroty;

    public UserEntity doLogin(String username, String password) {
        UserEntity user = userReposiroty.findByUsername(username);
        boolean match = CryptUtil.match(password, user.getPassword());
        return match ? user : null;
    }
}
