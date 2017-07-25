package com.pal.main;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.pal.consts.DataConfig;
import com.pal.listener.MKeyListener;
import com.pal.listener.MMouseListener;
import com.pal.map.LJCMap;
import com.pal.map.Map;
import com.pal.scene.MainMenu;
import com.pal.scene.StartCartoon;

import java.awt.*;

/**
 * 主窗体类
 */
public class MainFrame extends JFrame {

    /**
     * 开机动画
     * 
     */
    private StartCartoon startCartoon = new StartCartoon();

    /**
     * 李家村场景
     */
    private Map currentMap = new LJCMap();

    /**
     * 主菜单
     */
    private MainMenu mainMenu;

    public static void main(String[] args) {
        new MainFrame();
    }

    public MainFrame() {
        init();
        //设置窗体的位置 大小
        this.setBounds(DataConfig.MAIN_FRAME_X, DataConfig.MAIN_FRAME_Y, DataConfig.MAIN_FRAME_W, DataConfig.MAIN_FRAME_H);
        //关闭窗体时 关闭当前程序
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //当前默认为李家村
        this.add(mainMenu);
        //键盘监听事件注册
        this.addKeyListener(new MKeyListener(this));
        this.addMouseListener(new MMouseListener(this));
        //可见性
        this.setVisible(true);
        //开始动画
        action();
    }

    private void init() {
        mainMenu = new MainMenu(this);
    }

    public void action() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int isEnd = startCartoon.startPlay();
                if (isEnd == -1) {
                    removeCom(startCartoon);
                    addCom(mainMenu);
                    repaintCom();
                }
            }
        }).start();
    }

    public void removeCom(Component component) {
        this.remove(component);
    }

    public void addCom(Component component) {
        this.add(component);
    }

    public void repaintCom() {
        this.validate();
        this.repaint();
    }

    public void switchSceneToLJCMap() {
        this.remove(mainMenu);
        this.add(currentMap);
        repaintCom();
    }

    public Map getCurrentMap() {
        return currentMap;
    }

    public void setCurrentMap(Map currentMap) {
        this.currentMap = currentMap;
    }

}
