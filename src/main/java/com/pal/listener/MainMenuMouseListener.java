package com.pal.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.pal.scene.MainMenu;

/**
 * MainMenuMouseListener
 * 主菜单点击监听
 * Created by heqianqian on 2017/7/24.
 */
public class MainMenuMouseListener extends MouseAdapter {

	private MainMenu mainFrame;
	
    public MainMenuMouseListener(MainMenu mainMenu) {
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
