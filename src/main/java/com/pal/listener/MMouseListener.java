package com.pal.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.pal.main.MainFrame;

/**
 * MMouseListener
 * 自定义鼠标点击事件
 * Created by heqianqian on 2017/7/24.
 */
public class MMouseListener extends MouseAdapter {

    private MainFrame mainFrame;

    public MMouseListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println(e.getX() + "," + e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
    }

}
