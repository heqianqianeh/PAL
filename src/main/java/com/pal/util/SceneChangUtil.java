package com.pal.util;

import com.pal.consts.Const;
import com.pal.main.MainFrame;

/**
 * 
 * SceneChangUtil
 * 场景切换的工具类
 * 
 */
public class SceneChangUtil {
	
	/**
	 * 定义场景切换的方法
	 * @param mainFrame 主框体
	 * @param fromMap 当前地图
	 * @param msg 当前地图名称
	 */
	public static void changeScene(MainFrame mainFrame, com.pal.map.Map fromMap, String toMapName) {
	    mainFrame.remove(fromMap);
		
	    com.pal.map.Map toMap = null;
		try {
			Class<?> c = Class.forName(PropUtil.getString(PropUtil.loadProperties(Const.FILE_PATH), toMapName));
			toMap = (com.pal.map.Map) c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	    
		mainFrame.add(toMap);
        mainFrame.setCurrentMap(toMap);
        mainFrame.validate();
        mainFrame.repaint();
	}
	
}
