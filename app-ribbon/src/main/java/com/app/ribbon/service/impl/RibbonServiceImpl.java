package com.app.provider.service.impl;

import com.app.provider.service.RibbonService;
import com.core.model.DataModel;
import org.springframework.stereotype.Service;

/**
 * @author spring.yuan
 * @version 1.0
 */
@Service
public class RibbonServiceImpl implements RibbonService {

    @Override
    public DataModel queryUser(DataModel saveModel) {
        DataModel resultModel = new DataModel();
        return resultModel;
    }
}
