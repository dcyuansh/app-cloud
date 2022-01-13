package com.app.feign.repository;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author spring.yuan
 * @version 1.0
 */
@FeignClient(name = "app-provider")
public interface FeignRepository {

}
