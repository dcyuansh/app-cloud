package com.app.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
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
 * @author dc.yuan
 * @version 1.0
 */
@RestController
@RequestMapping("/api/consumer")
public class ConsumerController extends BaseController {

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
    @SentinelResource(value = "sentinel-consumer", blockHandler = "handleBlockMsg")
    @RequestMapping(method = RequestMethod.POST, value = "/query-user")
    public Map<String, Object> queryUser(@RequestBody Map<String, Object> requestMap) {
        DataModel resultModel = new DataModel();
        try {
            DataModel userModel = restTemplate.postForObject(REST_URL_PROVIDER_PREFIX + "/api/provider/query-user", requestMap, DataModel.class);
            this.handleSuccess(resultModel, userModel);
            logger.info("consumer call service success, call time:{}", LocalDateTime.now());
        } catch (ValidationException ve) {
            this.handleValidationException(resultModel, ve);
        } catch (Exception e) {
            this.handleException(resultModel, e);
        }
        return resultModel;
    }

    public Map<String, Object> handleBlockMsg(@RequestBody Map<String, Object> requestMap, BlockException exception) {
        DataModel resultModel = new DataModel();
        this.handleException(resultModel, new Exception("异常访问，你已经被限流访问！"));
        return resultModel;
    }

}
