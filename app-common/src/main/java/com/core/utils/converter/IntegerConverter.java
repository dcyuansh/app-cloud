package com.core.utils.converter;

import com.core.utils.NumberUtils;

/**
 * @author dc.yuan
 * @version 1.0
 */
public class IntegerConverter {

    public static Object convert(Class targetType, Object inputValue, Object nullValue) {
        Object convertedValue = null;
        if (Integer.class.isAssignableFrom(targetType) || Integer.TYPE.isAssignableFrom(targetType)) {
            if (inputValue instanceof Integer) {
                convertedValue = inputValue;
            } else if (inputValue instanceof Number) {
                convertedValue = ((Number) inputValue).intValue();
            } else if (inputValue == null || inputValue.toString().trim().equalsIgnoreCase("")) {
                convertedValue = nullValue;
            } else {
                convertedValue = NumberUtils.toInt(inputValue.toString());
            }
        } else {
            throw new IllegalArgumentException("Integer convert exception");
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
        return Integer.class;
    }
}
