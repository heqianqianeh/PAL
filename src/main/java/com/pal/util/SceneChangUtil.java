package com.pal.util;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.pal.consts.Const;
import com.pal.main.MainFrame;
import com.pal.map.Map;

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
	public static void changeScene(MainFrame mainFrame, Map fromMap, String toMapName) {
	    mainFrame.remove(fromMap);
		
	    Map toMap = null;
		try {
			Class<?> c = Class.forName(PropUtil.getString(PropUtil.loadProperties(Const.FILE_PATH), toMapName));
			toMap = (Map) c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	    
		mainFrame.add(toMap);
        mainFrame.setCurrentMap(toMap);
        mainFrame.validate();
        mainFrame.repaint();
	}
	
}
