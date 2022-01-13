package com.core.controller;

import com.core.constants.SystemConstant;
import com.core.exception.ValidationException;
import com.core.model.DataModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author spring.yuan
 * @version 1.0
 */
public abstract class BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 获取请求map参数，封装为DataModel对象
     *
     * @param requestMap
     * @return
     */
    protected DataModel getInputData(Map<String, Object> requestMap) {
        DataModel inputData = new DataModel();
        for (Map.Entry<String, Object> entry : requestMap.entrySet()) {
            inputData.put(entry.getKey(), entry.getValue(), true, false);
        }
        return inputData;
    }


    /**
     * 获取request请求参数，封装为DataModel对象
     *
     * @param request
     * @return
     */
    protected DataModel getInputData(HttpServletRequest request) {
        DataModel inputData = new DataModel();
        Enumeration en = request.getParameterNames();
        while (en.hasMoreElements()) {
            String paramName = (String) en.nextElement();
            String[] values = request.getParameterValues(paramName);
            if (values.length > 1) {
                inputData.put(paramName, values, true, false);
                List paramArrayList = new ArrayList();
                Collections.addAll(paramArrayList, values);
                if (request.getParameter(paramName + "List") == null)
                    inputData.put(paramName + "List", paramArrayList, true, false);
            } else {
                inputData.put(paramName, values[0], true, false);
            }
        }
        return inputData;
    }


    /**
     * 请求成功收，设置返回参数
     *
     * @param resultMap
     * @return
     */
    public Map<String, Object> handleSuccess(DataModel resultMap) {
        return this.handleSuccess(resultMap, null);
    }


    /**
     * 请求成功收，设置返回参数
     *
     * @param resultMap
     * @return
     */
    public Map<String, Object> handleSuccess(DataModel resultMap, Object obj) {
        if (resultMap == null) {
            resultMap = new DataModel();
        }
        resultMap.setFieldValue(SystemConstant.RESULT_STATUS, "success");
        resultMap.setFieldValue(SystemConstant.RESULT_CODE, "200");
        resultMap.setFieldValue(SystemConstant.RESULT_DATA, obj);
        resultMap.setFieldValue(SystemConstant.RESULT_MESSAGE, "");
        return resultMap;
    }


    /**
     * 请求有校验错误信息是，设置返回参数
     *
     * @param ve
     * @param resultMap
     * @return
     */
    public Map<String, Object> handleValidationException(DataModel resultMap, ValidationException ve) {
        if (resultMap == null) {
            resultMap = new DataModel();
        }
        resultMap.setFieldValue(SystemConstant.RESULT_STATUS, "fail");
        resultMap.setFieldValue(SystemConstant.RESULT_CODE, "400");
        resultMap.setFieldValue(SystemConstant.RESULT_DATA, null);
        resultMap.setFieldValue(SystemConstant.RESULT_MESSAGE, ve.getMessage());
        logger.warn("validation exception:{}", ve.getMessage());
        return resultMap;
    }


    /**
     * 请求发送异常时，设置返回参数
     *
     * @param e
     * @param resultMap
     * @return
     */
    public Map<String, Object> handleException(DataModel resultMap, Exception e) {
        if (resultMap == null) {
            resultMap = new DataModel();
        }
        resultMap.setFieldValue(SystemConstant.RESULT_STATUS, "fail");
        resultMap.setFieldValue(SystemConstant.RESULT_CODE, "500");
        resultMap.setFieldValue(SystemConstant.RESULT_DATA, null);
        resultMap.setFieldValue(SystemConstant.RESULT_MESSAGE, e.getMessage());
        logger.error("system runtime exception:{}", e.getMessage());
        return resultMap;
    }
}
