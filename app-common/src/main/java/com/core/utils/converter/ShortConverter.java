package com.core.utils.converter;

import com.core.utils.NumberUtils;

/**
 * @author dc.yuan
 * @version 1.0
 */
public class ShortConverter {

    public static Object convert(Class targetType, Object inputValue, Object nullValue) {
        Object convertedValue = null;
        if (Short.class.isAssignableFrom(targetType) || Short.TYPE.isAssignableFrom(targetType)) {
            if (inputValue instanceof Short) {
                convertedValue = inputValue;
            } else if (inputValue instanceof Number) {
                convertedValue = ((Number) inputValue).shortValue();
            } else if (inputValue == null || inputValue.toString().equalsIgnoreCase("")) {
                convertedValue = nullValue;
            } else {
                convertedValue = NumberUtils.toShort(inputValue.toString());
            }
        } else {
            throw new IllegalArgumentException("Short convert exception");
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
        return Short.class;
    }
}
