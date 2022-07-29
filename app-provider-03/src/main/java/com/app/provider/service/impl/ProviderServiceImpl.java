package com.app.provider.service.impl;

import com.app.provider.service.ProviderService;
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
        resultModel.setFieldValue("username", "王五");
        resultModel.setFieldValue("password", "123456");
        return resultModel;
    }
}
