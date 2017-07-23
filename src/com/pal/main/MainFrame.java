package com.pal.main;

import com.pal.consts.Const;
import com.pal.listener.MKeyListener;
import com.pal.map.InnMap;
import com.pal.map.LJCMap;
import com.pal.map.Map;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

/**
 * 主窗体类
 */
public class MainFrame extends JFrame{
    /**
     * 李家村场景
     */
    private Map currentMap = new LJCMap();

    public static void main(String[] args) {
        new MainFrame();
    }

    public MainFrame() {
        //设置窗体的位置 大小
        this.setBounds(100, 100, 800, 600);
        //关闭窗体时 关闭当前程序
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //当前默认为李家村
        this.add(currentMap);
        //键盘监听事件注册
        this.addKeyListener(new MKeyListener(this));
        //可见性
        this.setVisible(true);
    }

    public Map getCurrentMap() {
        return currentMap;
    }

    public void setCurrentMap(Map currentMap) {
        this.currentMap = currentMap;
    }
}
