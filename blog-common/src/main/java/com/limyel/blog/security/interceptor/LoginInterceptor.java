package com.limyel.blog.security.interceptor;

import com.limyel.blog.security.annotation.LoginRequired;
import org.springframework.core.annotation.AnnotationUtils;
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
