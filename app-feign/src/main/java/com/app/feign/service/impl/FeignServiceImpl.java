package com.app.feign.service.impl;

import com.app.feign.service.FeignService;
import com.core.model.DataModel;
import org.springframework.stereotype.Service;

/**
 * @author spring.yuan
 * @version 1.0
 */
@Service
public class FeignServiceImpl implements FeignService {

    @Override
    public DataModel queryUser(DataModel saveModel) {
        return null;
    }
}
