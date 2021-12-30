package com.core.utils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author spring.yuan
 * @version 1.0
 */
public class StringUtils {

    private static final char UNDERLINE = '_';
    private static final String DELIMITER = ",";
    private static final String UNIT = "万千佰拾亿千佰拾万千佰拾元角分";
    private static final String DIGIT = "零壹贰叁肆伍陆柒捌玖";
    private static final double MAX_VALUE = 9999999999999.99D;


    /***
     * format filed name
     * @param columnName
     * @return
     */
    public static String formatFieldName(String columnName) {
        String resultColumnName;
        if (StringUtils.isNotBlank(columnName)) {
            //去掉下划线，转为驼峰命名法
            resultColumnName = underlineToCamel(columnName.trim());
        } else {
            resultColumnName = "";
        }
        return resultColumnName;
    }


    /**
     * translate value
     *
     * @param value
     * @return
     */
    public static Object translateValue(Object value) {
        Object resultObject = value;
        if (value instanceof String) {
            String strValue = (String) value;
            if (StringUtils.isBlank(strValue)) {
                resultObject = null;
            } else {
                //这里可以根据string格式，将string转换为对应的object
            }
        }
        return resultObject;
    }


    /***
     * 将字符串中的下划线(_)去掉，后面第一个字母大写
     * @param param
     * @return
     */
    public static String underlineToCamel(String param) {
        if (StringUtils.isBlank(param)) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = Character.toLowerCase(param.charAt(i));
            if (c == UNDERLINE) {
                if (++i < len) {
                    sb.append(Character.toUpperCase(param.charAt(i)));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    /***
     * 判断字符是否为空，空格、制表符、tab
     * @param str
     * @return
     */
    public static boolean isBlank(CharSequence str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                // 判断字符是否为空格、制表符、tab
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }


    /***
     *　判断字符串不能为空，空格、制表符、tab
     * @param str
     * @return
     */
    public static boolean isNotBlank(CharSequence str) {
        return !isBlank(str);
    }


    /**
     * 判断所有字符串是有有为空，空格、制表符、tab
     *
     * @param css
     * @return
     */
    public static boolean isAnyBlank(CharSequence... css) {
        if (ArrayUtils.isEmpty(css)) {
            return false;
        } else {
            CharSequence[] var1 = css;
            int var2 = css.length;
            for (int var3 = 0; var3 < var2; ++var3) {
                CharSequence cs = var1[var3];
                if (isBlank(cs)) {
                    return true;
                }
            }
            return false;
        }
    }


    /**
     * 判断所有字符串，是不是都不为空，空格、制表符、tab
     *
     * @param css
     * @return
     */
    public static boolean isNoneBlank(CharSequence... css) {
        return !isAnyBlank(css);
    }


    /**
     * 判断所有字符串，是不是都为空，空格、制表符、tab
     *
     * @param css
     * @return
     */
    public static boolean isAllBlank(CharSequence... css) {
        if (ArrayUtils.isEmpty(css)) {
            return true;
        } else {
            CharSequence[] var1 = css;
            int var2 = css.length;
            for (int var3 = 0; var3 < var2; ++var3) {
                CharSequence cs = var1[var3];
                if (isNotBlank(cs)) {
                    return false;
                }
            }
            return true;
        }
    }


    /***
     * 判断是否为空字符串,没有判断空格
     * @param str
     * @return 如果为空，则返回true
     */
    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }


    /***
     * 判断字符串是否非空
     * @param str 如果不为空，则返回true
     * @return
     */
    public static boolean isNotEmpty(CharSequence str) {
        return !isEmpty(str);
    }


    /**
     * 判断是否有一个字符串是空，没有判断空格
     *
     * @param css
     * @return
     */
    public static boolean isAnyEmpty(CharSequence... css) {
        if (ArrayUtils.isEmpty(css)) {
            return false;
        } else {
            CharSequence[] var1 = css;
            int var2 = css.length;
            for (int var3 = 0; var3 < var2; ++var3) {
                CharSequence cs = var1[var3];
                if (isEmpty(cs)) {
                    return true;
                }
            }
            return false;
        }
    }


    /**
     * 所有字符串都部位空
     *
     * @param css
     * @return
     */
    public static boolean isNoneEmpty(CharSequence... css) {
        return !isAnyEmpty(css);
    }


    /**
     * 判断所有字符串是否都是空
     *
     * @param css
     * @return
     */
    public static boolean isAllEmpty(CharSequence... css) {
        if (ArrayUtils.isEmpty(css)) {
            return true;
        } else {
            CharSequence[] var1 = css;
            int var2 = css.length;
            for (int var3 = 0; var3 < var2; ++var3) {
                CharSequence cs = var1[var3];
                if (isNotEmpty(cs)) {
                    return false;
                }
            }
            return true;
        }
    }


    /**
     * 字符串trim
     *
     * @param str
     * @return
     */
    public static String trim(String str) {
        return str == null ? null : str.trim();
    }


    /**
     * 字符串截取，从第start个字符串开始截取
     *
     * @param str
     * @param start
     * @return
     */
    public static String subString(String str, int start) {
        if (str == null) {
            return null;
        } else {
            if (start < 0) {
                start += str.length();
            }
            if (start < 0) {
                start = 0;
            }
            return start > str.length() ? "" : str.substring(start);
        }
    }


    /**
     * 字符串截取，从位置start开始到位置end结束
     *
     * @param str
     * @param start
     * @param end
     * @return
     */
    public static String subString(String str, int start, int end) {
        if (str == null) {
            return null;
        } else {
            if (end < 0) {
                end += str.length();
            }
            if (start < 0) {
                start += str.length();
            }
            if (end > str.length()) {
                end = str.length();
            }
            if (start > end) {
                return "";
            } else {
                if (start < 0) {
                    start = 0;
                }
                if (end < 0) {
                    end = 0;
                }
                return str.substring(start, end);
            }
        }
    }


    /**
     * 字符串左边截取len长
     *
     * @param str
     * @param len
     * @return
     */
    public static String subStrLeft(String str, int len) {
        if (str == null) {
            return null;
        } else if (len < 0) {
            return "";
        } else {
            return str.length() <= len ? str : str.substring(0, len);
        }
    }


    /**
     * 字符串右边截取len长
     *
     * @param str
     * @param len
     * @return
     */
    public static String subStrRight(String str, int len) {
        if (str == null) {
            return null;
        } else if (len < 0) {
            return "";
        } else {
            return str.length() <= len ? str : str.substring(str.length() - len);
        }
    }


    /**
     * 从pos位置开始，截取长度为len
     *
     * @param str
     * @param pos
     * @param len
     * @return
     */
    public static String subStrMid(String str, int pos, int len) {
        if (str == null) {
            return null;
        } else if (len >= 0 && pos <= str.length()) {
            if (pos < 0) {
                pos = 0;
            }
            return str.length() <= pos + len ? str.substring(pos) : str.substring(pos, pos + len);
        } else {
            return "";
        }
    }


    /**
     * 判断两个字符串是否相等，区分大小写
     *
     * @param cs1
     * @param cs2
     * @return
     */
    public static boolean equals(CharSequence cs1, CharSequence cs2) {
        if (cs1 == cs2) {
            return true;
        } else if (cs1 != null && cs2 != null) {
            if (cs1.length() != cs2.length()) {
                return false;
            } else {
                return cs1 instanceof String && cs2 instanceof String ? cs1.equals(cs2) : CharSequenceUtils.regionMatches(cs1, false, 0, cs2, 0, cs1.length());
            }
        } else {
            return false;
        }
    }


    /**
     * 不区分大小写判断两个字符串是否相同
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean equalsIgnoreCase(CharSequence str1, CharSequence str2) {
        if (str1 != null && str2 != null) {
            if (str1 == str2) {
                return true;
            } else {
                return str1.length() != str2.length() ? false : CharSequenceUtils.regionMatches(str1, true, 0, str2, 0, str1.length());
            }
        } else {
            return str1 == str2;
        }
    }


    /**
     * 判断是否有一个字符串和string相同，有一个相同：true，否则：false
     *
     * @param string
     * @param searchStrings
     * @return
     */
    public static boolean equalsAny(CharSequence string, CharSequence... searchStrings) {
        if (ArrayUtils.isNotEmpty(searchStrings)) {
            CharSequence[] var2 = searchStrings;
            int var3 = searchStrings.length;
            for (int var4 = 0; var4 < var3; ++var4) {
                CharSequence next = var2[var4];
                if (equals(string, next)) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 不区分大小写，判断是否有一个字符串和string相同，有一个相同：true，否则：false
     *
     * @param string
     * @param searchStrings
     * @return
     */
    public static boolean equalsAnyIgnoreCase(CharSequence string, CharSequence... searchStrings) {
        if (ArrayUtils.isNotEmpty(searchStrings)) {
            CharSequence[] var2 = searchStrings;
            int var3 = searchStrings.length;
            for (int var4 = 0; var4 < var3; ++var4) {
                CharSequence next = var2[var4];
                if (equalsIgnoreCase(string, next)) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 判断seq是不是包含searchSeq，包含：true；不包含：false
     *
     * @param seq
     * @param searchSeq
     * @return
     */
    public static boolean contains(CharSequence seq, CharSequence searchSeq) {
        if (seq != null && searchSeq != null) {
            return CharSequenceUtils.indexOf(seq, searchSeq, 0) >= 0;
        } else {
            return false;
        }
    }


    /**
     * 不区分大小写,判断seq是不是包含searchSeq，包含：true；不包含：false
     *
     * @param str
     * @param searchStr
     * @return
     */
    public static boolean containsIgnoreCase(CharSequence str, CharSequence searchStr) {
        if (str != null && searchStr != null) {
            int len = searchStr.length();
            int max = str.length() - len;
            for (int i = 0; i <= max; ++i) {
                if (CharSequenceUtils.regionMatches(str, true, i, searchStr, 0, len)) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }


    /**
     * 判断是否包含其中一个char，包含：true，全不不包含：false
     *
     * @param cs
     * @param searchChars
     * @return
     */
    public static boolean containsAny(CharSequence cs, char... searchChars) {
        if (!isEmpty(cs) && !ArrayUtils.isEmpty(searchChars)) {
            int csLength = cs.length();
            int searchLength = searchChars.length;
            int csLast = csLength - 1;
            int searchLast = searchLength - 1;
            for (int i = 0; i < csLength; ++i) {
                char ch = cs.charAt(i);
                for (int j = 0; j < searchLength; ++j) {
                    if (searchChars[j] == ch) {
                        if (!Character.isHighSurrogate(ch)) {
                            return true;
                        }
                        if (j == searchLast) {
                            return true;
                        }
                        if (i < csLast && searchChars[j + 1] == cs.charAt(i + 1)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } else {
            return false;
        }
    }


    /**
     * 判断cs中是否包含searchChars中的任何一个字母，包含：true，不包含：false
     *
     * @param cs
     * @param searchChars
     * @return
     */
    public static boolean containsAny(CharSequence cs, CharSequence searchChars) {
        return searchChars == null ? false : containsAny(cs, CharSequenceUtils.toCharArray(searchChars));
    }


    /**
     * 判断是否包含其中一个string，包含：true，全不不包含：false
     *
     * @param cs
     * @param searchCharSequences
     * @return
     */
    public static boolean containsAny(CharSequence cs, CharSequence... searchCharSequences) {
        if (!isEmpty(cs) && !ArrayUtils.isEmpty(searchCharSequences)) {
            CharSequence[] var2 = searchCharSequences;
            int var3 = searchCharSequences.length;
            for (int var4 = 0; var4 < var3; ++var4) {
                CharSequence searchCharSequence = var2[var4];
                if (contains(cs, searchCharSequence)) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }


    /**
     * 用map替换String中的值，替换key为values
     *
     * @param str
     * @param map
     * @return
     */
    public static String replaceByMap(String str, Map<String, String> map) {
        String result = str;
        if (map == null || map.isEmpty()) {
            return result;
        }
        for (String _key : map.keySet()) {
            result = result.replace(_key, map.get(_key));
        }
        return result;
    }


    /***
     *  替换字符串，rep数值里面的值，为with
     * @param text
     * @param rep
     * @param with
     * @return
     */
    public static String replaceAll(String text, String[] rep, String with) {
        String result = text;
        for (int i = 0; i < rep.length; i++) {
            result = result.replace(rep[i], with);
        }
        return result;
    }


    /***
     * 将字符串，按照分隔符，拆分为字符串数组
     * @param value
     * @param delimiter
     * @return
     */
    public static String[] delimitedToArray(String value, String delimiter) {
        String[] list = null;
        if (value != null) {
            if (delimiter == null)
                delimiter = DELIMITER;
            StringTokenizer tok = new StringTokenizer(value, delimiter);
            list = new String[tok.countTokens()];
            int count = 0;
            while (tok.hasMoreTokens()) {
                String v = tok.nextToken();
                if (isNotEmpty(v)) {
                    list[count++] = v;
                }
            }
        }
        return list;
    }


    /***
     * 替换字符串，中的&key&，map中的values
     * @param content
     * @param map
     * @return
     */
    public static String replaceVariables(String content, Map<String, String> map) {
        if (isEmpty(content)) {
            return content;
        }
        Pattern quoteRegex = Pattern.compile("\\$\\w*\\$");
        Matcher quoteRegexMatcher = quoteRegex.matcher(content);
        while (quoteRegexMatcher.find()) {
            if (quoteRegexMatcher.group().length() > 1) {
                String variableName = quoteRegexMatcher.group().substring(1, quoteRegexMatcher.group().length() - 1);
                content = content.replace("$" + variableName + "$", map.get(variableName));
            }
        }
        return content;
    }


    /***
     * 将double钱转换为中文
     * @param v
     * @return
     */
    public static String convMonyToCHS(double v) {
        if (v < 0 || v > MAX_VALUE) {
            return "参数非法!";
        }
        long l = Math.round(v * 100);
        if (l == 0) {
            return "零元整";
        }
        String strValue = l + "";
        // i用来控制数
        int i = 0;
        // j用来控制单位
        int j = UNIT.length() - strValue.length();
        String rs = "";
        boolean isZero = false;
        for (; i < strValue.length(); i++, j++) {
            char ch = strValue.charAt(i);
            if (ch == '0') {
                isZero = true;
                if (UNIT.charAt(j) == '亿' || UNIT.charAt(j) == '万' || UNIT.charAt(j) == '元') {
                    rs = rs + UNIT.charAt(j);
                    isZero = false;
                }
            } else {
                if (isZero) {
                    rs = rs + "零";
                    isZero = false;
                }
                rs = rs + DIGIT.charAt(ch - '0') + UNIT.charAt(j);
            }
        }
        if (!rs.endsWith("分")) {
            rs = rs + "整";
        }
        rs = rs.replaceAll("亿万", "亿");
        return rs;
    }


    /***
     *  判断是不是中文字符
     * @param c
     * @return
     */
    public static boolean isChineseChar(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }


    /***
     * 判断是不是中文字符串
     * @param str
     * @return
     */
    public static boolean isChineseStr(String str) {
        boolean res = true;
        char[] cTemp = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (!isChineseChar(cTemp[i])) {
                res = false;
                break;
            }
        }
        return res;
    }


    /***
     * 判断字符串中是不是包含中文
     * @param str
     * @return
     */
    public static boolean containChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }


    /***
     * 去掉英文，只保留中文字符串
     * @param str
     * @return
     */
    public static String getCnStr(String str) {
        if (!StringUtils.isEmpty(str)) {
            String reg = "[^\u4e00-\u9fa5]";
            str = str.replaceAll(reg, "");
        }
        return str;
    }


    /***
     * 去掉中文，只保留英文字符串
     * @param str
     * @return
     */
    public static String getEnStr(String str) {
        if (!StringUtils.isEmpty(str)) {
            String reg = "[^a-zA-Z\\s+]";
            str = str.replaceAll(reg, "");
            str = str.trim();
            reg = "\\s{1,}";
            str = str.replaceAll(reg, " ");
        }
        return str;
    }


    /**
     * 字符串连接
     *
     * @param elements
     * @param <T>
     * @return
     */
    @SafeVarargs
    public static <T> String join(T... elements) {
        return join((Object[]) elements, (String) null);
    }


    /**
     * 用分隔符separator连接array中的数据
     *
     * @param array
     * @param separator
     * @return
     */
    public static String join(Object[] array, String separator) {
        return array == null ? null : join((Object[]) array, separator, 0, array.length);
    }


    /**
     * 用分隔符separator连接array中指定开始，结束位置的数据,
     *
     * @param array
     * @param separator
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static String join(Object[] array, String separator, int startIndex, int endIndex) {
        if (array == null) {
            return null;
        } else {
            if (separator == null) {
                separator = "";
            }
            int noOfItems = endIndex - startIndex;
            if (noOfItems <= 0) {
                return "";
            } else {
                StringBuilder buf = newStringBuilder(noOfItems);
                for (int i = startIndex; i < endIndex; ++i) {
                    if (i > startIndex) {
                        buf.append(separator);
                    }
                    if (array[i] != null) {
                        buf.append(array[i]);
                    }
                }
                return buf.toString();
            }
        }
    }


    /**
     * 用分隔符separator连接list中指定开始，结束位置的数据,
     *
     * @param list
     * @param separator
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static String join(List<?> list, String separator, int startIndex, int endIndex) {
        if (list == null) {
            return null;
        } else {
            int noOfItems = endIndex - startIndex;
            if (noOfItems <= 0) {
                return "";
            } else {
                List<?> subList = list.subList(startIndex, endIndex);
                return join(subList.iterator(), separator);
            }
        }
    }


    /**
     * 用分隔符separator连接集合数据
     *
     * @param iterator
     * @param separator
     * @return
     */
    public static String join(Iterator<?> iterator, String separator) {
        if (iterator == null) {
            return null;
        } else if (!iterator.hasNext()) {
            return "";
        } else {
            Object first = iterator.next();
            if (!iterator.hasNext()) {
                return Objects.toString(first, "");
            } else {
                StringBuilder buf = new StringBuilder(256);
                if (first != null) {
                    buf.append(first);
                }
                while (iterator.hasNext()) {
                    if (separator != null) {
                        buf.append(separator);
                    }
                    Object obj = iterator.next();
                    if (obj != null) {
                        buf.append(obj);
                    }
                }
                return buf.toString();
            }
        }
    }


    private static StringBuilder newStringBuilder(int noOfItems) {
        return new StringBuilder(noOfItems * 16);
    }


    /**
     * remove字符串中的指定子串
     *
     * @param str
     * @param remove
     * @return
     */
    public static String remove(String str, String remove) {
        return !isEmpty(str) && !isEmpty(remove) ? replace(str, remove, "", -1) : str;
    }


    /**
     * remove字符串中的指定子串,不区分大小写
     *
     * @param str
     * @param remove
     * @return
     */
    public static String removeIgnoreCase(String str, String remove) {
        return !isEmpty(str) && !isEmpty(remove) ? replaceIgnoreCase(str, remove, "", -1) : str;
    }

    public static String replace(String text, String searchString, String replacement, int max) {
        return replace(text, searchString, replacement, max, false);
    }

    public static String replaceIgnoreCase(String text, String searchString, String replacement, int max) {
        return replace(text, searchString, replacement, max, true);
    }

    private static String replace(String text, String searchString, String replacement, int max, boolean ignoreCase) {
        if (!isEmpty(text) && !isEmpty(searchString) && replacement != null && max != 0) {
            String searchText = text;
            if (ignoreCase) {
                searchText = text.toLowerCase();
                searchString = searchString.toLowerCase();
            }
            int start = 0;
            int end = searchText.indexOf(searchString, start);
            if (end == -1) {
                return text;
            } else {
                int replLength = searchString.length();
                int increase = replacement.length() - replLength;
                increase = increase < 0 ? 0 : increase;
                increase *= max < 0 ? 16 : (max > 64 ? 64 : max);
                StringBuilder buf;
                for (buf = new StringBuilder(text.length() + increase); end != -1; end = searchText.indexOf(searchString, start)) {
                    buf.append(text, start, end).append(replacement);
                    start = end + replLength;
                    --max;
                    if (max == 0) {
                        break;
                    }
                }
                buf.append(text, start, text.length());
                return buf.toString();
            }
        } else {
            return text;
        }
    }


    /**
     * 将字符串重复几次拼接在一起
     *
     * @param str
     * @param repeat
     * @return
     */
    public static String repeat(String str, int repeat) {
        if (str == null) {
            return null;
        } else if (repeat <= 0) {
            return "";
        } else {
            int inputLength = str.length();
            if (repeat != 1 && inputLength != 0) {
                if (inputLength == 1 && repeat <= 8192) {
                    return repeat(str.charAt(0), repeat);
                } else {
                    int outputLength = inputLength * repeat;
                    switch (inputLength) {
                        case 1:
                            return repeat(str.charAt(0), repeat);
                        case 2:
                            char ch0 = str.charAt(0);
                            char ch1 = str.charAt(1);
                            char[] output2 = new char[outputLength];
                            for (int i = repeat * 2 - 2; i >= 0; --i) {
                                output2[i] = ch0;
                                output2[i + 1] = ch1;
                                --i;
                            }
                            return new String(output2);
                        default:
                            StringBuilder buf = new StringBuilder(outputLength);
                            for (int i = 0; i < repeat; ++i) {
                                buf.append(str);
                            }
                            return buf.toString();
                    }
                }
            } else {
                return str;
            }
        }
    }


    /**
     * 将字符重复几次拼接在一起
     *
     * @param ch
     * @param repeat
     * @return
     */
    public static String repeat(char ch, int repeat) {
        if (repeat <= 0) {
            return "";
        } else {
            char[] buf = new char[repeat];
            for (int i = repeat - 1; i >= 0; --i) {
                buf[i] = ch;
            }
            return new String(buf);
        }
    }


    /**
     * 指定字符串长度，不够的左侧填充指定的字符padChar
     *
     * @param str
     * @param size
     * @param padChar
     * @return
     */
    public static String leftPad(String str, int size, char padChar) {
        if (str == null) {
            return null;
        } else {
            int pads = size - str.length();
            if (pads <= 0) {
                return str;
            } else {
                return pads > 8192 ? leftPad(str, size, String.valueOf(padChar)) : repeat(padChar, pads).concat(str);
            }
        }
    }


    /**
     * 指定字符串长度，不够的左侧填充指定的字符串padStr
     *
     * @param str
     * @param size
     * @param padStr
     * @return
     */
    public static String leftPad(String str, int size, String padStr) {
        if (str == null) {
            return null;
        } else {
            if (isEmpty(padStr)) {
                padStr = " ";
            }
            int padLen = padStr.length();
            int strLen = str.length();
            int pads = size - strLen;
            if (pads <= 0) {
                return str;
            } else if (padLen == 1 && pads <= 8192) {
                return leftPad(str, size, padStr.charAt(0));
            } else if (pads == padLen) {
                return padStr.concat(str);
            } else if (pads < padLen) {
                return padStr.substring(0, pads).concat(str);
            } else {
                char[] padding = new char[pads];
                char[] padChars = padStr.toCharArray();

                for (int i = 0; i < pads; ++i) {
                    padding[i] = padChars[i % padLen];
                }
                return (new String(padding)).concat(str);
            }
        }
    }


    /**
     * 指定字符串长度，不够的右侧填充指定的字符padChar
     *
     * @param str
     * @param size
     * @param padChar
     * @return
     */
    public static String rightPad(String str, int size, char padChar) {
        if (str == null) {
            return null;
        } else {
            int pads = size - str.length();
            if (pads <= 0) {
                return str;
            } else {
                return pads > 8192 ? rightPad(str, size, String.valueOf(padChar)) : str.concat(repeat(padChar, pads));
            }
        }
    }


    /**
     * 指定字符串长度，不够的左侧填充指定的字符串padStr
     *
     * @param str
     * @param size
     * @param padStr
     * @return
     */
    public static String rightPad(String str, int size, String padStr) {
        if (str == null) {
            return null;
        } else {
            if (isEmpty(padStr)) {
                padStr = " ";
            }
            int padLen = padStr.length();
            int strLen = str.length();
            int pads = size - strLen;
            if (pads <= 0) {
                return str;
            } else if (padLen == 1 && pads <= 8192) {
                return rightPad(str, size, padStr.charAt(0));
            } else if (pads == padLen) {
                return str.concat(padStr);
            } else if (pads < padLen) {
                return str.concat(padStr.substring(0, pads));
            } else {
                char[] padding = new char[pads];
                char[] padChars = padStr.toCharArray();
                for (int i = 0; i < pads; ++i) {
                    padding[i] = padChars[i % padLen];
                }
                return str.concat(new String(padding));
            }
        }
    }


    /**
     * 指定字符串长度，不够的两侧侧填充指定的字符padChar
     *
     * @param str
     * @param size
     * @param padChar
     * @return
     */
    public static String centerPad(String str, int size, char padChar) {
        if (str != null && size > 0) {
            int strLen = str.length();
            int pads = size - strLen;
            if (pads <= 0) {
                return str;
            } else {
                str = leftPad(str, strLen + pads / 2, padChar);
                str = rightPad(str, size, padChar);
                return str;
            }
        } else {
            return str;
        }
    }


    /**
     * 指定字符串长度，不够的两侧侧填充指定的字符padStr
     *
     * @param str
     * @param size
     * @param padStr
     * @return
     */
    public static String centerPad(String str, int size, String padStr) {
        if (str != null && size > 0) {
            if (isEmpty(padStr)) {
                padStr = " ";
            }
            int strLen = str.length();
            int pads = size - strLen;
            if (pads <= 0) return str;
            str = leftPad(str, strLen + pads / 2, padStr);
            str = rightPad(str, size, padStr);
            return str;
        } else {
            return str;
        }
    }


    /**
     * 判断子串在字符串中出现的次数
     *
     * @param str
     * @param sub
     * @return
     */
    public static int countMatches(CharSequence str, CharSequence sub) {
        if (!isEmpty(str) && !isEmpty(sub)) {
            int count = 0;
            for (int idx = 0; (idx = CharSequenceUtils.indexOf(str, sub, idx)) != -1; idx += sub.length()) {
                ++count;
            }
            return count;
        } else {
            return 0;
        }
    }


}
