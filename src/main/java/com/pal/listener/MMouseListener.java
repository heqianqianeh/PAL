package com.pal.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.pal.consts.DataConfig;
import com.pal.main.MainFrame;
import com.pal.main.MainMenu;

/**
 * MMouseListener
 * 自定义鼠标点击事件
 * Created by heqianqian on 2017/7/24.
 */
public class MMouseListener extends MouseAdapter {
	private MainMenu mainFrame;
	
    public MMouseListener(MainMenu mainMenu) {
    	this.mainFrame = mainMenu;
    }

	@Override
    public void mousePressed(MouseEvent e) {
		mainFrame.mousePressed(e);
	}

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
    }
    
}
