package com.core.utils.converter;

import com.core.utils.NumberUtils;

/**
 * @author dc.yuan
 * @version 1.0
 */
public class ByteConverter {

    public static Object convert(Class targetType, Object inputValue, Object nullValue) {
        Object convertedValue = null;
        if (Byte.class.isAssignableFrom(targetType)
                || Byte.TYPE.isAssignableFrom(targetType)) {
            if (inputValue instanceof Byte) {
                convertedValue = inputValue;
            } else if (inputValue instanceof Number) {
                convertedValue = ((Number) inputValue).byteValue();
            } else if (inputValue == null || inputValue.toString().equals("")) {
                convertedValue = nullValue;
            } else {
                convertedValue = NumberUtils.toByte(inputValue.toString());
            }
        } else {
            throw new IllegalArgumentException("Byte convert exception");
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
        return Byte.class;
    }
}
