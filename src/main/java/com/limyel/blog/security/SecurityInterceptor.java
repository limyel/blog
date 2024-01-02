package com.limyel.blog.security;

import com.limyel.blog.entity.UserEntity;
import com.limyel.blog.service.UserService;
import com.limyel.blog.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class SecurityInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 跨域请求
        if (HttpMethod.OPTIONS.name().equals(request.getMethod())) {
            return true;
        }

        if (isLoginFree(handler)) {
            return true;
        }

        UserEntity userEntity = handleLogin(request, response);
        ThreadLocalUtil.put(ThreadLocalUtil.CURRENT_USER, userEntity);

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    private boolean isLoginFree(Object handler) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;

            Class<?> controllerClass = handlerMethod.getBeanType();
            LoginRequired controllerLogin = AnnotationUtils.findAnnotation(controllerClass, LoginRequired.class);

            Method method = handlerMethod.getMethod();
            LoginRequired methodLogin = AnnotationUtils.getAnnotation(method, LoginRequired.class);

            return ObjectUtils.isEmpty(controllerLogin) && ObjectUtils.isEmpty(methodLogin);
        }

        return true;
    }

    private UserEntity handleLogin(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader("Authorization");
        if (!StringUtils.hasText(token)) {
            throw new RuntimeException();
        }
        return userService.getByToken(token);
    }

}
