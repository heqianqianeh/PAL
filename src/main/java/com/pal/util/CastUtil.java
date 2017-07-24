package com.pal.util;


/**
 * CastUtil
 * 转换数据类型帮助类
 * Created by heqianqian on 2017/7/19.
 */
public class CastUtil {

    /**
     * cast Object to String
     *
     * @param property 配置文件
     * @return String
     */
    public static String castString(Object property) {
        return castString(property, "");
    }

    /**
     * cast Object to String [defaultValue]
     *
     * @param property     配置文件
     * @param defaultValue 默认值
     * @return String
     */
    public static String castString(Object property, String defaultValue) {
        return property == null ? defaultValue : String.valueOf(property);
    }

    /**
     * cast Object to Boolean
     *
     * @param property 配置文件
     * @return boolean
     */
    public static boolean castBoolean(Object property) {
        return castBoolean(property, false);
    }

    /**
     * cast Object to Boolean [defaultValue]
     *
     * @param property     配置文件
     * @param defaultValue 默认值
     * @return boolean
     */
    public static boolean castBoolean(Object property, boolean defaultValue) {
        boolean value = defaultValue;
        if (property != null) {
            String prop = String.valueOf(property);
            if (StringUtil.isNotEmpty(prop)) {
                try {
                    value = Boolean.parseBoolean(prop);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }

    /**
     * cast Object to Integer
     *
     * @param property 配置文件
     * @return int
     */
    public static int castInt(Object property) {
        return castInt(property, 0);
    }

    /**
     * cast Object to Integer [defaultValue]
     *
     * @param property     配置文件
     * @param defaultValue 默认值
     * @return int
     */
    public static int castInt(Object property, int defaultValue) {
        int value = defaultValue;
        if (property != null) {
            String prop = String.valueOf(property);
            if (StringUtil.isNotEmpty(prop)) {
                value = Integer.parseInt(prop);
            }
        }
        return value;
    }
}
