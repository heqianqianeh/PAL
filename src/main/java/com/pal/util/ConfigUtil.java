package com.pal.util;

import com.pal.consts.Const;

import java.util.Properties;

/**
 * ConfigUtil
 * 获取属性文件信息
 * Created by heqianqian on 2017/7/19.
 */
public class ConfigUtil {

    /**
     * 配置文件
     */
    private static final Properties propertis = PropUtil.loadProperties(Const.FILE_PATH);

    /**
     * 获取字符串属性
     *
     * @param propertiesName 属性名称
     * @return String
     */
    public static String getStringProperties(String propertiesName) {
        return PropUtil.getString(propertis, propertiesName);
    }

    /**
     * 获取整型属性
     *
     * @param propertiesName 属性名称
     * @return Integer
     */
    public static Integer getIntegerProperties(String propertiesName) {
        return PropUtil.getInt(propertis, propertiesName);
    }

    /**
     * 获取布尔属性
     *
     * @param propertiesName 属性名称
     * @return Boolean
     */
    public static Boolean getBooleanProperties(String propertiesName) {
        return PropUtil.getBoolean(propertis, propertiesName);
    }
}
