package com.app.ribbon.controller;

import com.core.controller.BaseController;
import com.core.exception.ValidationException;
import com.core.model.DataModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author spring.yuan
 * @version 1.0
 */
@RestController
@RequestMapping("/api/ribbon")
public class RibbonController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //面向微服务编程，即通过微服务的名称来获取调用地址
    // 使用注册到 Spring Cloud Eureka 服务注册中心中的服务，即 application.name
    private static final String REST_URL_PROVIDER_PREFIX = "http://app-provider";

    @Autowired
    private RestTemplate restTemplate;


    /***
     * query all comm_task
     * @param requestMap
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/query-user")
    public Map<String, Object> queryUser(@RequestBody Map<String, Object> requestMap) {
        DataModel resultModel = new DataModel();
        try {
            DataModel queryModel = this.getInputData(requestMap);
            DataModel userModel = restTemplate.postForObject(REST_URL_PROVIDER_PREFIX + "/api/provider/query-user", requestMap, DataModel.class);
            this.handleSuccess(resultModel, userModel);
            logger.info("ribbon call service success, call time:{}", LocalDateTime.now());
        } catch (ValidationException ve) {
            this.handleValidationException(resultModel, ve);
        } catch (Exception e) {
            this.handleException(resultModel, e);
        }
        return resultModel;
    }

}
