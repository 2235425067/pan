package com.hadoop.config;

import com.jwt.Interceptor.AuthInterceptor;
import com.jwt.Interceptor.JwtInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("PUT", "POST", "GET", "OPTIONS").maxAge(3600);
    }
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    /**
     * 添加jwt拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(initAuthInterceptor())
                // 拦截所有请求，通过判断是否有 @JwtToken 注解 决定是否需要登录
                .addPathPatterns("/**").excludePathPatterns("/loginjson/**")
                .excludePathPatterns("/**/*.html","/**/*.js","/**/*.css")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
    }

    /**
     * jwt拦截器
     * @return
     */
    @Bean
    public JwtInterceptor jwtInterceptor() {
        return new JwtInterceptor();
    }
    @Bean
    public AuthInterceptor initAuthInterceptor(){
        return new AuthInterceptor();
    }
}
