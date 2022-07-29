package com.app.config;

import feign.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * @author spring.yuan
 * @version 1.0
 */
@Configurable
public class OpenFeignLoggingConfig {

    @Bean
    Logger.Level openFeignLogLevel() {
        return Logger.Level.FULL;
    }
}
