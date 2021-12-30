package com.core.utils;

import java.util.UUID;

/**
 * @author spring.yuan
 * @version 1.0
 */
public class UUidUtils {

    /***
     * get uuid
     * @return
     */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }


    /***
     * get uuid code
     * @return
     */
    public static String getUUIDCode() {
        String uuid = UUID.randomUUID().toString();
        String code = uuid.replace("-", "");
        return code;
    }

}
