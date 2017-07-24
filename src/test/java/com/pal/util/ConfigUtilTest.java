package com.pal.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ConfigUtilTest
 * Created by heqianqian on 2017/7/24.
 */
public class ConfigUtilTest {
    @Test
    public void test() throws Exception {
        Integer integerProperties = ConfigUtil.getIntegerProperties("lxy.x");
        System.out.println(integerProperties);
    }
}