package com.app.openfeign.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.app.openfeign.service.FeignService;
import com.core.controller.AbstractBaseController;
import com.core.exception.ValidationException;
import com.core.model.DataModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author DC Yuan
 * @version 1.0
 */
@RestController
@RequestMapping("/api/feign")
public class FeignControllerAbstract extends AbstractBaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FeignService feignService;


    /***
     * query all comm_task
     * @param requestMap
     * @return
     */
    @SentinelResource(value = "sentinel-consumer-openfeign", fallback = "handlerFallback")
    @RequestMapping(method = RequestMethod.POST, value = "/query-user")
    public Map<String, Object> queryUser(@RequestBody Map<String, Object> requestMap) {
        DataModel resultModel = new DataModel();
        try {
            DataModel queryModel = this.getInputData(requestMap);
            DataModel userInfo = feignService.queryUser(queryModel);
            this.handleSuccess(resultModel, userInfo.getFieldValue("data"));
            logger.info("feign call user info success, request time:{}", LocalDateTime.now());
        } catch (ValidationException ve) {
            this.handleValidationException(resultModel, ve);
        } catch (Exception e) {
            this.handleException(resultModel, e);
        }
        return resultModel;
    }


    public Map<String, Object> handlerFallback(@RequestBody Map<String, Object> requestMap, Throwable e) {
        DataModel resultModel = new DataModel();
        this.handleException(resultModel, new Exception("接口访问异常，服务已经被降级！"));
        return resultModel;
    }
}
