package com.feiniaojin.ddd.ui.web.config;

import com.feiniaojin.ddd.application.service.user.TokenApplicationService;
import com.feiniaojin.gracefulresponse.EnableGracefulResponse;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author thy
 */
@Configuration
@EnableGracefulResponse
public class WebConfig implements WebMvcConfigurer {

    @Resource
    TokenApplicationService tokenApplicationService;


    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor(tokenApplicationService));
    }
}
