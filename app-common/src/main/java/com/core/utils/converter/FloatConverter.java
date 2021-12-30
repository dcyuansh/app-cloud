package com.core.utils.converter;

import com.core.utils.NumberUtils;

/**
 * @author spring.yuan
 * @version 1.0
 */
public class FloatConverter {

    public static Object convert(Class targetType, Object inputValue, Object nullValue) {
        Object convertedValue = null;
        if (Float.class.isAssignableFrom(targetType)
                || Float.TYPE.isAssignableFrom(targetType)) {
            if (inputValue instanceof Float) {
                convertedValue = inputValue;
            } else if (inputValue instanceof Number) {
                convertedValue = ((Number) inputValue).floatValue();
            } else if (inputValue == null
                    || inputValue.toString().equalsIgnoreCase("")) {
                convertedValue = nullValue;
            } else {
                convertedValue = NumberUtils.toFloat(inputValue.toString());
            }
        } else {
            throw new IllegalArgumentException("Float convert exception");
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
        return Float.class;
    }
}
