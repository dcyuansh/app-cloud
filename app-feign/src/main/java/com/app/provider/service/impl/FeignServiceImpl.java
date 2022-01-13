package com.app.provider.service.impl;

import com.app.provider.repository.FeignRepository;
import com.app.provider.service.FeignService;
import com.core.model.DataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author spring.yuan
 * @version 1.0
 */
@Service
public class FeignServiceImpl implements FeignService {

    @Autowired
    private FeignRepository feignRepository;

    @Override
    public DataModel queryUser(DataModel requestModel) {
        return feignRepository.queryUser(requestModel);
    }
}
