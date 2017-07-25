package com.pal.person;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.pal.enums.WalkDir;

public class NH {
    /*女孩素材*/
    private final static Image[] IMG_UP = new Image[8];
    private final static Image[] IMG_DOWN = new Image[8];
    private final static Image[] IMG_LEFT = new Image[8];
    private final static Image[] IMG_RIGHT = new Image[8];
    private WalkDir walkDir = WalkDir.DOWN;

    //设置女孩键盘控制的数组的索引值
    private int upIndex, downIndex, leftIndex, rightIndex;

    static {
        try {
            for (int i = 0; i < IMG_UP.length; i++) {
                IMG_UP[i] = ImageIO.read(new File("img\\女孩上\\" + i + ".jpg"));
                IMG_DOWN[i] = ImageIO.read(new File("img\\女孩下\\" + i + ".jpg"));
                IMG_LEFT[i] = ImageIO.read(new File("img\\女孩左\\" + i + ".jpg"));
                IMG_RIGHT[i] = ImageIO.read(new File("img\\女孩右\\" + i + ".jpg"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void paint(Graphics g) {
        switch (walkDir) {
            case DOWN:
                g.drawImage(IMG_DOWN[downIndex], 400, 300, null);
                break;
            case LEFT:
                g.drawImage(IMG_LEFT[leftIndex], 400, 300, null);
                break;
            case RIGHT:
                g.drawImage(IMG_RIGHT[rightIndex], 400, 300, null);
                break;
            case UP:
                g.drawImage(IMG_UP[upIndex], 400, 300, null);
                break;
            default:
                break;
        }
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                walkDir = WalkDir.DOWN;
                downIndex = (downIndex + 1) > 3 ? 0 : (downIndex + 1);
                break;
            case KeyEvent.VK_UP:
                walkDir = WalkDir.UP;
                upIndex = (upIndex + 1) > 3 ? 0 : (upIndex + 1);
                break;
            case KeyEvent.VK_LEFT:
                walkDir = WalkDir.LEFT;
                leftIndex = (leftIndex + 1) > 3 ? 0 : (leftIndex + 1);
                break;
            case KeyEvent.VK_RIGHT:
                walkDir = WalkDir.RIGHT;
                rightIndex = (rightIndex + 1) > 3 ? 0 : (rightIndex + 1);
                break;
            default:
                break;
        }
    }

}
