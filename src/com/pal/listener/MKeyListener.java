package com.pal.listener;

import com.pal.consts.Const;
import com.pal.main.MainFrame;
import com.pal.map.InnMap;
import com.pal.map.LJCMap;
import com.pal.map.Map;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * MKeyListener
 * 自定义
 * Created by heqianqian on 2017/7/23.
 */
public class MKeyListener extends KeyAdapter {

    private MainFrame mainFrame;

    public MKeyListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Map currentMap = mainFrame.getCurrentMap();
        String msg = currentMap.keyPressed(e);
        //根据 keyPressed 返回值来进行判断  空串在当前场景 ，如果为客栈 ，切换到客栈场景 移除李家村场景 ，如果为李家村，切换到李家村，移除客栈场景
        if (msg != null) {
            mainFrame.remove(currentMap);
            switch (msg) {
                case Const.INN:
                    currentMap = new InnMap();
                    break;
                case Const.VILLAGE_LI:
                    currentMap = new LJCMap();
                    break;
                default:
                    break;
            }
            mainFrame.add(currentMap);
            mainFrame.setCurrentMap(currentMap);
            mainFrame.validate();
            mainFrame.repaint();
        }
    }
}
