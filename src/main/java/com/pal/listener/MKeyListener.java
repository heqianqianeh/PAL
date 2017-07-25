package com.pal.listener;

import com.pal.main.MainFrame;
import com.pal.util.SceneChangUtil;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * MKeyListener
 * 主窗体键盘监听事件
 * Created by heqianqian on 2017/7/23.
 */
public class MKeyListener extends KeyAdapter {

    private MainFrame mainFrame;

    public MKeyListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        com.pal.map.Map currentMap = mainFrame.getCurrentMap();
        String msg = currentMap.keyPressed(e);
        //根据 keyPressed 返回值来进行判断  空串在当前场景 ，如果为客栈 ，切换到客栈场景 移除李家村场景 ，如果为李家村，切换到李家村，移除客栈场景
        if (msg != null) {
           //进行场景切换
           SceneChangUtil.changeScene(mainFrame, currentMap, msg);
        }
    }
}
