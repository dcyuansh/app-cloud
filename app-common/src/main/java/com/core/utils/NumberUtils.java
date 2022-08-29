package com.core.utils;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author dc.yuan
 * @version 1.0
 */
public class NumberUtils {

    public static final Integer INTEGER_TWO = 2;

    public NumberUtils() {
    }

    public static int toInt(String str) {
        return toInt(str, 0);
    }

    public static int toInt(String str, int defaultValue) {
        if (str == null) {
            return defaultValue;
        } else {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException var3) {
                return defaultValue;
            }
        }
    }

    public static long toLong(String str) {
        return toLong(str, 0L);
    }

    public static long toLong(String str, long defaultValue) {
        if (str == null) {
            return defaultValue;
        } else {
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException var4) {
                return defaultValue;
            }
        }
    }

    public static float toFloat(String str) {
        return toFloat(str, 0.0F);
    }

    public static float toFloat(String str, float defaultValue) {
        if (str == null) {
            return defaultValue;
        } else {
            try {
                return Float.parseFloat(str);
            } catch (NumberFormatException var3) {
                return defaultValue;
            }
        }
    }

    public static double toDouble(String str) {
        return toDouble(str, 0.0D);
    }

    public static double toDouble(String str, double defaultValue) {
        if (str == null) {
            return defaultValue;
        } else {
            try {
                return Double.parseDouble(str);
            } catch (NumberFormatException var4) {
                return defaultValue;
            }
        }
    }

    public static double toDouble(BigDecimal value) {
        return toDouble(value, 0.0D);
    }

    public static double toDouble(BigDecimal value, double defaultValue) {
        return value == null ? defaultValue : value.doubleValue();
    }

    public static byte toByte(String str) {
        return toByte(str, (byte) 0);
    }

    public static byte toByte(String str, byte defaultValue) {
        if (str == null) {
            return defaultValue;
        } else {
            try {
                return Byte.parseByte(str);
            } catch (NumberFormatException var3) {
                return defaultValue;
            }
        }
    }

    public static short toShort(String str) {
        return toShort(str, (short) 0);
    }

    public static short toShort(String str, short defaultValue) {
        if (str == null) {
            return defaultValue;
        } else {
            try {
                return Short.parseShort(str);
            } catch (NumberFormatException var3) {
                return defaultValue;
            }
        }
    }

    public static BigDecimal toScaledBigDecimal(BigDecimal value) {
        return toScaledBigDecimal(value, INTEGER_TWO, RoundingMode.HALF_EVEN);
    }

    public static BigDecimal toScaledBigDecimal(BigDecimal value, int scale, RoundingMode roundingMode) {
        return value == null ? BigDecimal.ZERO : value.setScale(scale, roundingMode == null ? RoundingMode.HALF_EVEN : roundingMode);
    }

    public static BigDecimal toScaledBigDecimal(Float value) {
        return toScaledBigDecimal(value, INTEGER_TWO, RoundingMode.HALF_EVEN);
    }

    public static BigDecimal toScaledBigDecimal(Float value, int scale, RoundingMode roundingMode) {
        return value == null ? BigDecimal.ZERO : toScaledBigDecimal(BigDecimal.valueOf((double) value), scale, roundingMode);
    }

    public static BigDecimal toScaledBigDecimal(Double value) {
        return toScaledBigDecimal(value, INTEGER_TWO, RoundingMode.HALF_EVEN);
    }

    public static BigDecimal toScaledBigDecimal(Double value, int scale, RoundingMode roundingMode) {
        return value == null ? BigDecimal.ZERO : toScaledBigDecimal(BigDecimal.valueOf(value), scale, roundingMode);
    }

    public static BigDecimal toScaledBigDecimal(String value) {
        return toScaledBigDecimal(value, INTEGER_TWO, RoundingMode.HALF_EVEN);
    }

    public static BigDecimal toScaledBigDecimal(String value, int scale, RoundingMode roundingMode) {
        return value == null ? BigDecimal.ZERO : toScaledBigDecimal(createBigDecimal(value), scale, roundingMode);
    }

    public static BigDecimal createBigDecimal(String str) {
        if (str == null) {
            return null;
        } else if (StringUtils.isBlank(str)) {
            throw new NumberFormatException("A blank string is not a valid number");
        } else if (str.trim().startsWith("--")) {
            throw new NumberFormatException(str + " is not a valid number.");
        } else {
            return new BigDecimal(str);
        }
    }

    public static long min(long... array) {
        validateArray(array);
        long min = array[0];

        for (int i = 1; i < array.length; ++i) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    public static int min(int... array) {
        validateArray(array);
        int min = array[0];

        for (int j = 1; j < array.length; ++j) {
            if (array[j] < min) {
                min = array[j];
            }
        }

        return min;
    }

    public static short min(short... array) {
        validateArray(array);
        short min = array[0];

        for (int i = 1; i < array.length; ++i) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    public static byte min(byte... array) {
        validateArray(array);
        byte min = array[0];

        for (int i = 1; i < array.length; ++i) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    public static double min(double... array) {
        validateArray(array);
        double min = array[0];

        for (int i = 1; i < array.length; ++i) {
            if (Double.isNaN(array[i])) {
                return 0.0D / 0.0;
            }

            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    public static float min(float... array) {
        validateArray(array);
        float min = array[0];

        for (int i = 1; i < array.length; ++i) {
            if (Float.isNaN(array[i])) {
                return 0;
            }

            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    public static long max(long... array) {
        validateArray(array);
        long max = array[0];

        for (int j = 1; j < array.length; ++j) {
            if (array[j] > max) {
                max = array[j];
            }
        }

        return max;
    }

    public static int max(int... array) {
        validateArray(array);
        int max = array[0];

        for (int j = 1; j < array.length; ++j) {
            if (array[j] > max) {
                max = array[j];
            }
        }

        return max;
    }

    public static short max(short... array) {
        validateArray(array);
        short max = array[0];

        for (int i = 1; i < array.length; ++i) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    public static byte max(byte... array) {
        validateArray(array);
        byte max = array[0];

        for (int i = 1; i < array.length; ++i) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    public static double max(double... array) {
        validateArray(array);
        double max = array[0];

        for (int j = 1; j < array.length; ++j) {
            if (Double.isNaN(array[j])) {
                return 0.0D / 0.0;
            }

            if (array[j] > max) {
                max = array[j];
            }
        }

        return max;
    }

    public static float max(float... array) {
        validateArray(array);
        float max = array[0];

        for (int j = 1; j < array.length; ++j) {
            if (Float.isNaN(array[j])) {
                return (float) (0.0F / 0.0);
            }

            if (array[j] > max) {
                max = array[j];
            }
        }

        return max;
    }

    private static void validateArray(Object array) {
        isTrue(array != null, "The Array must not be null", new Object[0]);
        isTrue(Array.getLength(array) != 0, "Array cannot be empty.", new Object[0]);
    }

    private static void isTrue(boolean expression, String message, Object... values) {
        if (!expression) {
            throw new IllegalArgumentException(String.format(message, values));
        }
    }

}
