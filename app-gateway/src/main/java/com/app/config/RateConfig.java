package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author DC Yuan
 * @version 1.0
 * @date 2022-11-10 17:15
 */
@Component
public class RateConfig {
    @Bean
    public UrlKeyResolver urlKeyResolver() {
        return new UrlKeyResolver();
    }
}
