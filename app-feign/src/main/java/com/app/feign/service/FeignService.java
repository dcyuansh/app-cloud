package com.app.feign.service;

import com.core.model.DataModel;

/**
 * @author spring.yuan
 * @version 1.0
 */
public interface FeignService {

    DataModel queryUser(DataModel saveModel);
}
