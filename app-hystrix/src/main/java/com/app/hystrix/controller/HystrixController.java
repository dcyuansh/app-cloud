package com.app.hystrix.controller;

import com.app.hystrix.service.HystrixService;
import com.core.controller.BaseController;
import com.core.exception.ValidationException;
import com.core.model.DataModel;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
 * @author spring.yuan
 * @version 1.0
 */
@RestController
@RequestMapping("/api/hystrix")
public class HystrixController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HystrixService hystrixService;


    /***
     * query all comm_task
     * @param requestMap
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/query-user")
    @HystrixCommand(fallbackMethod = "timeOutHandler")
    public Map<String, Object> queryUser(@RequestBody Map<String, Object> requestMap) {
        DataModel resultModel = new DataModel();
        try {
            DataModel queryModel = this.getInputData(requestMap);
            DataModel userInfo = hystrixService.queryUser(queryModel);
            this.handleSuccess(resultModel, userInfo.getFieldValue("data"));
            logger.info("hystrix call user info success, request time:{}", LocalDateTime.now());
        } catch (ValidationException ve) {
            this.handleValidationException(resultModel, ve);
        } catch (Exception e) {
            this.handleException(resultModel, e);
        }
        return resultModel;
    }


    // timeout方法的 专用 fallback 方法
    public Map<String, Object> timeOutHandler(@RequestBody Map<String, Object> requestMap) {
        DataModel resultModel = new DataModel();
        try {
            DataModel dataModel = new DataModel();
            dataModel.setFieldValue("info", "timeout 出错，服务已被降级！");
            this.handleSuccess(resultModel, dataModel);
            logger.info("timeout 出错，服务已被降级！");
        } catch (ValidationException ve) {
            this.handleValidationException(resultModel, ve);
        } catch (Exception e) {
            this.handleException(resultModel, e);
        }
        return resultModel;
    }

}
