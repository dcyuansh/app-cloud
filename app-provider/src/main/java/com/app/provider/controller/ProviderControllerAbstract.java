package com.app.provider.controller;

import com.app.provider.service.ProviderService;
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
@RequestMapping("/api/provider")
public class ProviderControllerAbstract extends AbstractBaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProviderService providerService;


    /***
     * query all comm_task
     * @param requestMap
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/query-user")
    public Map<String, Object> queryUser(@RequestBody Map<String, Object> requestMap) {
        DataModel resultModel = new DataModel();
        try {
            //for test
            //TimeUnit.SECONDS.sleep(6);
            DataModel queryModel = this.getInputData(requestMap);
            DataModel userModel = providerService.queryUser(queryModel);
            this.handleSuccess(resultModel, userModel);
            logger.info("call provider service success, request time:{}", LocalDateTime.now());
        } catch (ValidationException ve) {
            this.handleValidationException(resultModel, ve);
        } catch (Exception e) {
            this.handleException(resultModel, e);
        }
        return resultModel;
    }

}
