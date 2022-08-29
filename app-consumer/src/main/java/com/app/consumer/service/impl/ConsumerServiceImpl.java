package com.app.consumer.service.impl;

import com.app.consumer.service.ConsumerService;
import com.core.model.DataModel;
import org.springframework.stereotype.Service;

/**
 * @author dc.yuan
 * @version 1.0
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Override
    public DataModel queryUser(DataModel saveModel) {
        DataModel resultModel = new DataModel();
        return resultModel;
    }
}
