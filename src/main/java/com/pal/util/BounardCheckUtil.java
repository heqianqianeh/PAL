package com.pal.util;

/**
 * 定义有关边界碰撞检测的工具类
 * @author cwq
 * @version V1.0 2017/7/26
 */
public class BounardCheckUtil {

	/**
	 * 判断地图是否已经加载到 最左端
	 * @param mapMaxOffsetXReverse 地图X轴最大反向偏移
	 * @param initOffsetX 地图初始的偏移量  x
	 * @param movedOffsetX  地图移动的偏移量  x
	 * @return 地图是否已经加载到 最左端
	 */
	public static boolean mapIsLoadLeft(int mapMaxOffsetXReverse, int initOffsetX, int movedOffsetX) {
		if (-initOffsetX+movedOffsetX <= mapMaxOffsetXReverse) {
			return true;
		}
		return false;
	}

	/**
	 * 判断地图是否已经加载到 最顶端
	 * @param mapMaxOffsetYReverse 地图X轴最大反向偏移
	 * @param initOffsetY 地图初始的偏移量    y
	 * @param movedOffsetY  地图移动的偏移量    y
	 * @return 地图是否已经加载到 最顶端
	 */
	public static boolean mapIsLoadHead(int mapMaxOffsetYReverse, int initOffsetY, int movedOffsetY) {
		if (-initOffsetY+movedOffsetY <= mapMaxOffsetYReverse) {
			return true;
		}
		return false;
	}

	/**
	 * 判断地图是否已经加载到 最顶端
	 * @param mapWidth 地图宽度
	 * @param initOffsetX 地图初始的偏移量    x
	 * @param movedOffsetX  地图移动的偏移量    x
	 * @return 地图是否已经加载到 最右端
	 */
	public static boolean mapIsLoadRight(int mapWidth, int initOffsetX, int movedOffsetX) {
		if (-(initOffsetX*2)+movedOffsetX >= mapWidth) {
			return true;
		}
		return false;
	}

	/**
	 * 判断地图是否已经加载到 最底端
	 * @param mapHeight 地图高度
	 * @param initOffsetY 地图初始的偏移量    y
	 * @param movedOffsetY  地图移动的偏移量    y
	 * @return 地图是否已经加载到 最顶端
	 */
	public static boolean mapIsLoadBottom(int mapHeight, int initOffsetY, int movedOffsetY) {
		if (-(initOffsetY*2)+movedOffsetY >= mapHeight) {
			return true;
		}
		return false;
	}

}
