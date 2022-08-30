package com.app.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dc.yuan
 * @version 1.0
 */
@RestController
@RefreshScope
@RequestMapping("/api/nacos")
public class NacosConfigController {

    @Value("${config.info}")
    private String ConfigInfo;


    @RequestMapping(method = RequestMethod.GET, value = "/config/info")
    public String getConfigInfo() {
        return ConfigInfo;
    }
}
