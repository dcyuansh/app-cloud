package com.app.feign.service.impl;

import com.app.feign.service.ProviderService;
import com.core.model.DataModel;
import org.springframework.stereotype.Service;

/**
 * @author spring.yuan
 * @version 1.0
 */
@Service
public class ProviderServiceImpl implements ProviderService {

    @Override
    public DataModel queryUser(DataModel saveModel) {
        DataModel resultModel = new DataModel();
        resultModel.setFieldValue("username", "张三");
        resultModel.setFieldValue("password", "123456");
        return resultModel;
    }
}
