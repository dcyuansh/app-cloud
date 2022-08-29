package com.core.utils.converter;

import com.core.utils.NumberUtils;

import java.util.Date;

/**
 * @author dc.yuan
 * @version 1.0
 */
public class LongConverter {

    public static Object convert(Class targetType, Object inputValue, Object nullValue) {
        Object convertedValue = null;
        if (Long.class.isAssignableFrom(targetType)
                || Long.TYPE.isAssignableFrom(targetType)) {
            if (inputValue instanceof Long) {
                convertedValue = inputValue;
            } else if (inputValue instanceof Number) {
                convertedValue = ((Number) inputValue).longValue();
            } else if (inputValue instanceof Date) {
                convertedValue = ((Date) inputValue).getTime();
            } else if (inputValue == null
                    || inputValue.toString().equalsIgnoreCase("")) {
                convertedValue = nullValue;
            } else {
                convertedValue = NumberUtils.toLong(inputValue.toString());
            }
        } else {
            throw new IllegalArgumentException("Long convert exception");
        }
        return convertedValue;
    }

    public static Object convert(Object inputValue, Object nullValue) {
        return convert(getDefaultTargetType(), inputValue, nullValue);
    }

    public static Object convert(Object inputValue) {
        return convert(inputValue, null);
    }

    public static Class getDefaultTargetType() {
        return Long.class;
    }
}
