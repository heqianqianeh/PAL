package com.pal.util;

import java.awt.*;

/**
 * MouseUtil
 * Created by heqianqian on 2017/7/25.
 */
public class MouseUtil {


    /**
     * 判断鼠标是否处于某区域
     *
     * @param startX 起始x坐标
     * @param startY 起始y坐标
     * @param endX   终止x坐标
     * @param endY   终止y坐标
     * @param xShift x偏移量
     * @param yShift y偏移量
     * @return 是否处于某区域
     */
    public static boolean judgeMouse(int startX, int endX, int startY, int endY, int xShift, int yShift) {
        Point location = MouseInfo.getPointerInfo().getLocation();
        int x = location.x + xShift;
        int y = location.y + yShift;
        return (x >= startX && x <= endX && y >= startY && y <= endY);
    }
}
