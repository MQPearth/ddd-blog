package com.feiniaojin.ddd.ui.web.config;

import com.feiniaojin.ddd.application.service.user.TokenApplicationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Objects;


/**
 * <p>AuthInterceptor</p>
 *
 * @author thy
 */
public class AuthInterceptor implements HandlerInterceptor {


    TokenApplicationService tokenApplicationService;

    public AuthInterceptor(TokenApplicationService tokenApplicationService) {
        this.tokenApplicationService = tokenApplicationService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        if (handler instanceof HandlerMethod handlerMethod) {
            Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
            if (Objects.nonNull(auth)) {
                String token = request.getHeader("token");
                if (StringUtils.isBlank(token)) {
                    throw new RuntimeException("未登录");
                }
                Integer userId = tokenApplicationService.auth(token);
                if (Objects.isNull(userId)) {
                    throw new RuntimeException("登录已过期");
                }
                request.setAttribute("userId", userId);
            }

        }
        return true;
    }
}
