package com.core.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import java.util.Arrays;
import java.util.List;

/**
 * @author spring.yuan
 * @version 1.0
 */
public class FastJsonUtil {

    /***
     * object to json
     * @param object
     * @return
     */
    public static JSON objectToJson(Object object) {
        JSON resultJson = null;
        if (object != null) {
            resultJson = JSON.parseObject(JSON.toJSONString(object));
        }
        return resultJson;
    }

    /***
     * object to json exclude keys
     * @param object
     * @param excludeKeys
     * @return
     */
    public static JSON objectToJson(Object object, String... excludeKeys) {
        JSON resultJson = null;
        if (object != null && excludeKeys != null) {
            List<String> excludes = Arrays.asList(excludeKeys);
            SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
            filter.getExcludes().addAll(excludes);    //重点！！！
            resultJson = JSON.parseObject(JSON.toJSONString(object, filter));
        }
        return resultJson;
    }

    /***
     * object to json exclude list key
     * @param object
     * @param excludeKeys
     * @return
     */
    public static JSON objectToJson(Object object, List<String> excludeKeys) {
        JSON resultJson = null;
        if (object != null && excludeKeys != null) {
            SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
            filter.getExcludes().addAll(excludeKeys);    //重点！！！
            resultJson = JSON.parseObject(JSON.toJSONString(object, filter));
        }
        return resultJson;
    }

    /***
     * json to object
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T jsonToObject(String json, Class<T> clazz) {
        T object = null;
        if (json != null) {
            object = JSON.parseObject(json, clazz);
        }
        return object;
    }
}


