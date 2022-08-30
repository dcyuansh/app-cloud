package com.app.config.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dc.yuan
 * @version 1.0
 */
@RestController
@RequestMapping("/api/gateway")
public class GatewayController {


    @RequestMapping(method = RequestMethod.GET, value = "/info")
    public String getConfigInfo() {
        return "call gateway success";
    }
}
