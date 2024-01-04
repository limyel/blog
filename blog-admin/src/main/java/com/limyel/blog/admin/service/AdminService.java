package com.limyel.blog.admin.service;

import com.limyel.blog.admin.dao.AdminDao;
import com.limyel.blog.admin.dto.LoginDTO;
import com.limyel.blog.admin.entity.AdminEntity;
import com.limyel.blog.admin.vo.TokenVO;
import com.limyel.blog.common.config.BlogConfig;
import com.limyel.blog.common.util.RsaUtil;
import com.limyel.blog.security.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private BlogConfig blogConfig;

    public TokenVO login(LoginDTO dto) {
        AdminEntity admin = adminDao.selectOne(null);
        String token = JwtUtil.generateJwtToken(admin.getId(), RsaUtil.getPrivateKey(), blogConfig.getJwt().getExpire());
        TokenVO result = new TokenVO();
        result.setToken(token);
        return result;
    }

}
