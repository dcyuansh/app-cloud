package com.core.utils.converter;

import com.core.utils.NumberUtils;

import java.math.BigDecimal;

/**
 * @author spring.yuan
 * @version 1.0
 */
public class BigDecimalConverter {

    public static Object convert(Class targetType, Object inputValue, Object nullValue) {
        Object convertedValue = null;
        if (BigDecimal.class.isAssignableFrom(targetType)) {
            if (inputValue instanceof BigDecimal) {
                convertedValue = inputValue;
            } else if (inputValue instanceof Number) {
                convertedValue = new BigDecimal(((Number) inputValue).doubleValue());
            } else if (inputValue == null
                    || inputValue.toString().equalsIgnoreCase("")) {
                convertedValue = nullValue;
            } else {
                convertedValue = NumberUtils.toScaledBigDecimal(inputValue.toString());
            }
        } else {
            throw new IllegalArgumentException("BigDecimal convert exception");
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
        return BigDecimal.class;
    }
}
