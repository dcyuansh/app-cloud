package com.core.utils.converter;

/**
 * @author spring.yuan
 * @version 1.0
 */
public class StringConverter {

    public static Object convert(Class targetType, Object inputValue, Object nullValue) {
        Object convertedValue = null;
        if (String.class.isAssignableFrom(targetType)) {
            if (inputValue == null) {
                convertedValue = nullValue;
            } else if (inputValue instanceof String) {
                convertedValue = inputValue;
            } else {
                convertedValue = String.valueOf(inputValue.toString());
            }
        } else {
            throw new IllegalArgumentException("String convert exception");
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
        return String.class;
    }
}
