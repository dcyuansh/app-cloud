package com.app.hystrix.service;

import com.core.model.DataModel;

/**
 * @author spring.yuan
 * @version 1.0
 */
public interface HystrixService {

    DataModel queryUser(DataModel requestModel);
}
