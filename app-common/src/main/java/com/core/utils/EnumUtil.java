package com.core.utils;

import com.core.enums.CodeEnum;
import com.core.enums.CodeMessageEnum;

/**
 * @author spring.yuan
 * @version 1.0
 */
public class EnumUtil {


    /***
     * 对应只有code的枚举，通过code获取枚举对象
     * @param code
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T extends CodeEnum> T getEnumByCd(String code, Class<T> tClass) {
        for (T each : tClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }


    /***
     * 通过code编码获取枚举对象
     * @param code   枚举的编码
     * @param tClass 枚举类
     * @param <T>
     * @return
     */
    public static <T extends CodeMessageEnum> T getEnumByCode(String code, Class<T> tClass) {
        for (T each : tClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }


    /***
     * 通过code编码获取枚举对象
     * @param message 枚举的msg
     * @param tClass 枚举类
     * @param <T>
     * @return
     */
    public static <T extends CodeMessageEnum> T getEnumByMessage(String message, Class<T> tClass) {
        for (T each : tClass.getEnumConstants()) {
            if (message.equals(each)) {
                return each;
            }
        }
        return null;
    }
}
