package com.core.utils;

import java.lang.reflect.Array;

/**
 * @author spring.yuan
 * @version 1.0
 */
public class ArrayUtils {

    public static boolean isEmpty(char[] array) {
        return getLength(array) == 0;
    }

    public static boolean isEmpty(Object[] array) {
        return getLength(array) == 0;
    }

    public static <T> boolean isNotEmpty(T[] array) {
        return getLength(array) != 0;
    }

    public static int getLength(Object array) {
        return array == null ? 0 : Array.getLength(array);
    }

}
