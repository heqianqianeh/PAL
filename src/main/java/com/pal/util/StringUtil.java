package com.pal.util;

import org.apache.commons.lang3.StringUtils;

/**
 * StringUtil
 * 字符串帮助类
 * 对 {@link StringUtils} 进行封装
 * <p>
 * Created by heqianqian on 2017/7/19.
 */
public class StringUtil {

    /**
     * 判断字符串是否为空
     *
     * @param str 字符串
     * @return boolean
     */
    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
     * 判断字符串非空
     *
     * @param str 字符串
     * @return boolean
     */
    public static boolean isNotEmpty(String str) {
        return !StringUtils.isEmpty(str);
    }
}
