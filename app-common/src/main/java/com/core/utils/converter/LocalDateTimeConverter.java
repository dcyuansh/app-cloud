package com.core.utils.converter;

import com.core.utils.LocalDateTimeUtils;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author DC Yuan
 * @version 1.0
 */
public class LocalDateTimeConverter {

    public static Object convert(Class targetType, Object inputValue, Object nullValue) {
        Object convertedValue = null;
        if (LocalDateTime.class.isAssignableFrom(targetType)) {
            if (inputValue instanceof LocalDateTime) {
                convertedValue = inputValue;
            } else if (inputValue == null
                    || inputValue.toString().equalsIgnoreCase("")) {
                convertedValue = nullValue;
            } else {
                convertedValue = LocalDateTimeUtils.formatTime(inputValue.toString(), null);
            }
        } else {
            throw new IllegalArgumentException("LocalDate convert exception");
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
        return Date.class;
    }
}
