package com.pal.util;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * 窗体工具类
 */
public class FrameUtil {

	/**
	 * 设置居中
	 */
	public static void  setFrameCenter(JFrame frame){
		//设置位置
		Toolkit tk = frame.getToolkit();
		Dimension screen = tk.getScreenSize();
		int x = screen.width - frame.getWidth()>>1;
		int y = (screen.height - frame.getHeight()>>1) - 20;
		frame.setLocation(x,y);
	}
}
