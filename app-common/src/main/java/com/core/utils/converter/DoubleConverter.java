package com.core.utils.converter;

import com.core.utils.NumberUtils;

/**
 * @author dc.yuan
 * @version 1.0
 */
public class DoubleConverter {

    public static Object convert(Class targetType, Object inputValue, Object nullValue) {
        Object convertedValue = null;
        if (Double.class.isAssignableFrom(targetType)
                || Double.TYPE.isAssignableFrom(targetType)) {
            if (inputValue instanceof Double) {
                convertedValue = inputValue;
            } else if (inputValue instanceof Number) {
                convertedValue = ((Number) inputValue).doubleValue();
            } else if (inputValue == null
                    || inputValue.toString().equalsIgnoreCase("")) {
                convertedValue = nullValue;
            } else {
                convertedValue = NumberUtils.toDouble(inputValue.toString());
            }
        } else {
            throw new IllegalArgumentException("Double convert exception");
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
        return Double.class;
    }
}
