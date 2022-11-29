package com.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * @author DC Yuan
 * @version 1.0
 * @date 2022-09-01 11:26
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        //允许所有请求方法，例如get，post等
        config.addAllowedMethod("*");
        //允许所有的请求来源
        config.addAllowedOriginPattern("*");
        config.addAllowedOrigin("*");
        //允许所有请求头
        config.addAllowedHeader("*");
        //允许携带cookie
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        //对所有经过网关的请求都生效
        source.registerCorsConfiguration("/**", config);

        return new CorsWebFilter(source);
    }
}
