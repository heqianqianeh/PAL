package com.pal.map;

import com.pal.consts.DataConfig;

import javax.imageio.ImageIO;
import java.awt.*;
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

    static {
        try {
            IMG_FIGHT = ImageIO.read(new File("img\\树林\\forest.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(IMG_FIGHT, 0, 0, DataConfig.MAIN_FRAME_W, DataConfig.MAIN_FRAME_H, 0, 0, 640, 480, null);
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
