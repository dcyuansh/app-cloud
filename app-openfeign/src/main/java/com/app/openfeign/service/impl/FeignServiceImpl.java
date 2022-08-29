package com.app.openfeign.service.impl;

import com.app.openfeign.repository.FeignRepository;
import com.app.openfeign.service.FeignService;
import com.core.model.DataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dc.yuan
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
