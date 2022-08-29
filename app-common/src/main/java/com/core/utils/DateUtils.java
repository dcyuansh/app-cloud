package com.core.utils;

import com.core.constants.SystemConstant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author dc.yuan
 * @version 1.0
 */
public class DateUtils {

    /***
     * formate date user def, return string
     * @param date
     * @param pattern
     * @return
     */
    public static String dateFormat(Date date, String pattern) {
        if (date == null) return null;
        SimpleDateFormat formatter = new SimpleDateFormat(pattern == null ? SystemConstant.DATE_TIME_FORMAT : pattern);
        String formResult = null;
        try {
            formResult = formatter.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formResult;
    }


    /****
     * string convert date,user def format
     * @param dateTime
     * @return
     */
    public static Date formatDate(String dateTime, String pattern) {
        if (dateTime == null) return null;
        SimpleDateFormat formatter = new SimpleDateFormat(pattern == null ? SystemConstant.DATE_FORMAT : pattern);
        Date resultDate = null;
        try {
            resultDate = formatter.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultDate;
    }


    /**
     * 获取两个日期相差的月数
     */
    public static int getMonthDiff(Date dateBegin, Date DateEnd) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(dateBegin);
        c2.setTime(DateEnd);
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int month2 = c2.get(Calendar.MONTH);
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        int day2 = c2.get(Calendar.DAY_OF_MONTH);
        // 获取年的差值
        int yearInterval = year1 - year2;
        // 如果 d1的 月-日 小于 d2的 月-日 那么 yearInterval-- 这样就得到了相差的年数
        if (month1 < month2 || month1 == month2 && day1 < day2) {
            yearInterval--;
        }
        // 获取月数差值
        int monthInterval = (month1 + 12) - month2;
        if (day1 < day2) {
            monthInterval--;
        }
        monthInterval %= 12;
        int monthsDiff = Math.abs(yearInterval * 12 + monthInterval);
        return monthsDiff;
    }
}
