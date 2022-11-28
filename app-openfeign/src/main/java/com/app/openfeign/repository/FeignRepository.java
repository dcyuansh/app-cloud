package com.app.openfeign.repository;

import com.app.openfeign.repository.impl.FeignRepositoryFallBackImpl;
import com.core.model.DataModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author dc.yuan
 * @version 1.0
 */
@FeignClient(name = "app-provider", fallback = FeignRepositoryFallBackImpl.class)
@Component
public interface FeignRepository {

    /**
     * 调用app-provider service查询用户信息
     *
     * @param requestMap
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/api/provider/query-user")
    DataModel queryUser(@RequestBody DataModel requestMap);

}
