package com.bs.mycareer.Common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("https://localhost:8080") // 허용하려는 도메인을 명시
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
