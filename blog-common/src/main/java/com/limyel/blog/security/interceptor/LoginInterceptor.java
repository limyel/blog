package com.limyel.blog.security.interceptor;

import com.limyel.blog.common.config.BlogConfig;
import com.limyel.blog.common.constant.BlogConstant;
import com.limyel.blog.common.util.RsaUtil;
import com.limyel.blog.common.util.SpringContextUtil;
import com.limyel.blog.common.util.ThreadLocalUtil;
import com.limyel.blog.security.annotation.LoginRequired;
import com.limyel.blog.security.config.UserEntity;
import com.limyel.blog.security.config.UserService;
import com.limyel.blog.security.jwt.JwtUtil;
import com.limyel.blog.security.jwt.TokenPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 跨域
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }

        // 没有 @LoginRequired，无需登录
        if (isLoginFree(handler)) {
            return true;
        }

        BlogConfig blogConfig = SpringContextUtil.getBean(BlogConfig.class);
        UserService userService = SpringContextUtil.getBean(UserService.class);

        String authorization = request.getHeader(blogConfig.getJwt().getHeader());
        String token = authorization.replace(blogConfig.getJwt().getStart(), "").trim();
        TokenPayload payload = JwtUtil.parseToken(token, RsaUtil.getPublicKey());
        UserEntity user = userService.getById(payload.getAdminId());
        ThreadLocalUtil.put(BlogConstant.CURRENT_USER, user);

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    private boolean isLoginFree(Object obj) {
        if (obj instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) obj;
            Method method = handlerMethod.getMethod();
            LoginRequired annotation = AnnotationUtils.getAnnotation(method, LoginRequired.class);
            return annotation == null;
        }
        return true;
    }

}
