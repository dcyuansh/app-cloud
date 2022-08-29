package com.app.openfeign.service;

import com.core.model.DataModel;

/**
 * @author dc.yuan
 * @version 1.0
 */
public interface FeignService {

    DataModel queryUser(DataModel requestModel);
}
