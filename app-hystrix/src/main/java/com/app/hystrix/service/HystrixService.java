package com.app.hystrix.service;

import com.core.model.DataModel;

/**
 * @author dc.yuan
 * @version 1.0
 */
public interface HystrixService {

    DataModel queryUser(DataModel requestModel);
}
