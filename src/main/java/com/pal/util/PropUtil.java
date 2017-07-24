package com.pal.util;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * PropUtil
 * 属性文件工具类
 * Created by heqianqian on 2017/7/19.
 */
public class PropUtil {

    /**
     * 加载配置文件
     *
     * @param propertiesPath 配置文件路径
     * @return Properties
     */
    public static Properties loadProperties(String propertiesPath) {
        Properties properties = null;
        InputStream inputStream = null;
        try {
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(propertiesPath);
            if (inputStream == null) {
                throw new FileNotFoundException("Properties Not Found!");
            }
            properties = new Properties();
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }


    /**
     * 获取字符串类型属性
     *
     * @param properties 配置文件
     * @param key        键值
     * @return 属性值
     */
    public static String getString(Properties properties, String key) {
        return getString(properties, key, "");
    }

    /**
     * 获取字符串类型属性[存在默认值]
     *
     * @param properties   配置文件
     * @param key          键值
     * @param defaultValue 默认值
     * @return 属性值
     */
    public static String getString(Properties properties, String key, String defaultValue) {
        String value = defaultValue;
        if (properties.containsKey(key)) {
            value = properties.getProperty(key);
        }
        return value;
    }

    /**
     * 获取整型类型属性
     *
     * @param properties 配置文件
     * @param key        键值
     * @return 属性值
     */
    public static int getInt(Properties properties, String key) {
        return getInt(properties, key, 0);
    }

    /**
     * 获取整型属性值[带默认值]
     *
     * @param properties   配置文件
     * @param key          键值
     * @param defaultValue 默认值
     * @return int 属性值
     */
    public static int getInt(Properties properties, String key, Integer defaultValue) {
        int value = defaultValue;
        if (properties.containsKey(key)) {
            value = CastUtil.castInt(properties.get(key));
        }
        return value;
    }


    /**
     * 获取布尔属性值[默认值]
     *
     * @param properties 配置文件
     * @param key        键值
     * @return boolean 属性值
     */
    public static boolean getBoolean(Properties properties, String key) {
        return getBoolean(properties, key, false);
    }

    /**
     * 获取布尔属性值[默认值]
     *
     * @param properties   配置文件
     * @param key          键值
     * @param defaultValue 默认值
     * @return boolean 属性值
     */
    public static boolean getBoolean(Properties properties, String key, boolean defaultValue) {
        boolean value = defaultValue;
        if (properties.containsKey(key)) {
            value = CastUtil.castBoolean(properties.get(key));
        }
        return value;
    }

}
