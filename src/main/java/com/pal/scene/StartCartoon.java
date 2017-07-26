package com.pal.scene;

import com.pal.consts.DataConfig;

import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * 开机动画
 */
public class StartCartoon extends JPanel {

    private static Image[] IMG_MENULOOP = new Image[181];

    /**
     * 开始动画的数组索引值
     */
    private int menuIndex = 0;

    /**
     * 音乐播放
     */
    private static AudioClip audio = null;

    static {
        try {
            for (int i = 0; i < IMG_MENULOOP.length; i++) {
                IMG_MENULOOP[i] = ImageIO.read(new File("img\\开始动画\\" + i + ".png"));
            }
            audio = JApplet.newAudioClip(new File("music\\op.wav").toURL());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        if (menuIndex == 0) {
            g.drawImage(IMG_MENULOOP[menuIndex], 0, 0, DataConfig.MAIN_FRAME_W, DataConfig.MAIN_FRAME_H, 0, 0, 960, 540, null);
        } else {
            g.drawImage(IMG_MENULOOP[menuIndex], 0, 0, DataConfig.MAIN_FRAME_W, DataConfig.MAIN_FRAME_H, 0, 0, DataConfig.MOVIE_W, DataConfig.MOVIE_H, null);
        }
    }

    /**
     * 开始播放
     */
    public int startPlay() {
        audio.play();//播放音乐
        while (true) {
            if (menuIndex == 0) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (++menuIndex >= 180) {
                audio.stop();
                return -1;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }

}
