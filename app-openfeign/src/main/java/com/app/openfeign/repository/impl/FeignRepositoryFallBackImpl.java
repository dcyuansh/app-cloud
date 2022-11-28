package com.app.openfeign.repository.impl;

import com.app.openfeign.repository.FeignRepository;
import com.core.model.DataModel;
import org.springframework.stereotype.Component;

/**
 * 服务降级fall back方法
 *
 * @author DC Yuan
 * @version 1.0
 * @date 2022-11-17 16:35
 */
@Component
public class FeignRepositoryFallBackImpl implements FeignRepository {

    @Override
    public DataModel queryUser(DataModel requestMap) {
        DataModel result = new DataModel();
        result.setFieldValue("message", "对不起,你访问的资源被降级");
        return result;
    }
}
