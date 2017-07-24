package com.pal.map;

import com.pal.consts.DataConfig;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class MenuLoop extends JPanel {
<<<<<<< HEAD
	
=======

>>>>>>> af07240329e9fbdeb61e2973c83f52c0ddf85404
    private static Image[] IMG_MENULOOP = new Image[180];

    /**
     * 开始动画的数组索引值
     */
    private int menuIndex;

    static {
        try {
            for (int i = 1; i < IMG_MENULOOP.length; i++) {
                IMG_MENULOOP[i] = ImageIO.read(new File("img\\开始动画\\" + i + ".png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        g.drawImage(IMG_MENULOOP[menuIndex], 0, 0, DataConfig.MAIN_FRAME_W, DataConfig.MAIN_FRAME_H, 0, 0, DataConfig.MOVIE_W, DataConfig.MOVIE_H, null);
    }

    public int loopPic() {
        boolean isLoop = true;
        while (isLoop) {
            if (++menuIndex >= 179) {
                return -1;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
        return -1;
    }
}
