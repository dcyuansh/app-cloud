package com.core.utils.converter;

/**
 * @author DC Yuan
 * @version 1.0
 */
public class BooleanConverter {

    public static Object convert(Class targetType, Object inputValue, Object nullValue) {
        Object convertedValue = null;
        if (Boolean.class.isAssignableFrom(targetType)
                || Boolean.TYPE.isAssignableFrom(targetType)) {
            if (inputValue instanceof Boolean) {
                convertedValue = inputValue;
            } else if (inputValue == null) {
                convertedValue = nullValue;
            } else {
                convertedValue = Boolean.valueOf(inputValue.toString());
            }
        } else {
            throw new IllegalArgumentException("Boolean convert exception");
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
        return Boolean.class;
    }
}