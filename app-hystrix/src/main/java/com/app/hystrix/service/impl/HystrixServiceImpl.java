package com.app.hystrix.service.impl;

import com.app.hystrix.repository.HystrixRepository;
import com.app.hystrix.service.HystrixService;
import com.core.model.DataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author spring.yuan
 * @version 1.0
 */
@Service
public class HystrixServiceImpl implements HystrixService {

    @Autowired
    private HystrixRepository hystrixRepository;

    @Override
    public DataModel queryUser(DataModel requestModel) {
        return hystrixRepository.queryUser(requestModel);
    }
}
