package com.pal.main;

import com.pal.consts.DataConfig;
import com.pal.listener.MKeyListener;
import com.pal.map.LJCMap;
import com.pal.map.Map;
import com.pal.map.MenuLoop;

import javax.swing.*;
import java.awt.*;

/**
 * 主窗体类
 */
public class MainFrame extends JFrame {

    /**
     * 开机动画
     */
    private MenuLoop menuLoop = new MenuLoop();

    /**
     * 李家村场景
     */
    private Map currentMap = new LJCMap();

    /**
     * 主菜单
     */
    private MainMenu mainMenu = new MainMenu();

    public static void main(String[] args) {
        new MainFrame();
    }

    public MainFrame() {
        //设置窗体的位置 大小
        this.setBounds(DataConfig.MAIN_FRAME_X, DataConfig.MAIN_FRAME_Y, DataConfig.MAIN_FRAME_W, DataConfig.MAIN_FRAME_H);
        //关闭窗体时 关闭当前程序
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //当前默认为李家村
        this.add(menuLoop);
        //键盘监听事件注册
        this.addKeyListener(new MKeyListener(this));
        //可见性
        this.setVisible(true);
        //场景动画
        action();
    }

    public void action() {
        new Thread(new Runnable() {
            int result = 0;

            @Override
            public void run() {
                while (true) {
                    result = menuLoop.loopPic();
                    System.out.println("result=" + result);
                    if (result == -1) {
                        removeCom(menuLoop);
                        addCom(currentMap);
                        repaintFrame();
                        currentMap.loopPic();
                    }
                }
            }
        }).start();
    }

    public void addCom(Component comp) {
        this.add(comp);
    }

    public void removeCom(Component comp) {
        this.remove(comp);
    }

    public void repaintFrame() {
        this.repaint();
        this.addKeyListener(new MKeyListener(this));
    }

    public Map getCurrentMap() {
        return currentMap;
    }

    public void setCurrentMap(Map currentMap) {
        this.currentMap = currentMap;
    }
}
