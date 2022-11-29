package com.core.utils;

import com.core.constants.SystemConstant;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author DC Yuan
 * @version 1.0
 */
public class LocalDateUtils {


    /***
     * 获取指定时间的指定格式,默认格式(yyyy-MM-dd)
     * @param time
     * @param pattern
     * @return
     */
    public static String formatDate(LocalDate time, String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern == null ? SystemConstant.DATE_FORMAT : pattern));
    }


    /***
     *将string转换为指定格式的日期,默认格式(yyyy-MM-dd)
     * @param time
     * @param pattern
     * @return
     */
    public static LocalDate formatDate(String time, String pattern) {
        return LocalDate.parse(time, DateTimeFormatter.ofPattern(pattern == null ? SystemConstant.DATE_FORMAT : pattern));
    }
}
