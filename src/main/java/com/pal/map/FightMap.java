package com.pal.map;

import com.pal.consts.Const;
import com.pal.consts.DataConfig;
import com.pal.enums.SkillEnum;
import com.pal.listener.MKeyListener;
import com.pal.person.BY;
import com.pal.person.FLXY;
import com.pal.person.LXY;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

/**
 * FightMap
 * 战斗场景
 * Created by heqianqian on 2017/7/26.
 */
public class FightMap extends Map {

    private static Image IMG_FIGHT = null;

    private FLXY flxy = new FLXY();

    private BY by = new BY();

    private SkillEnum skillEnum = SkillEnum.WJCX;

    private LXY lxy = new LXY();

    static {
        try {
            IMG_FIGHT = ImageIO.read(new File("img\\树林\\forest.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FightMap() {
        run();
    }

    private void run() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    validate();
                    repaint();
                }
            }
        }).start();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(IMG_FIGHT, 0, 0, DataConfig.MAIN_FRAME_W, DataConfig.MAIN_FRAME_H, 0, 0, 640, 480, null);
        switch (skillEnum) {
            case DL:
                skillEnum = by.paintDL(g);
                break;
            case JIANJ:
                skillEnum = flxy.paintWJJ(g);
                break;
            case SMZH:
                skillEnum = by.paintSMZH(g);
                break;
            case WJCX:
                skillEnum = flxy.paintCX(g);
                break;
            default:
                lxy.paint(g);
                break;
        }

    }

    @Override
    public String keyPressed(KeyEvent e) {
        return null;
    }

    @Override
    public int mousePressed(MouseEvent e) {
        return 0;
    }
}
