package com.pal.map;

import com.pal.consts.Const;
import com.pal.person.LXY;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

/**
 * 客栈场景
 */
public class InnMap extends Map {
	
	/**
	 * 客栈地图的名称
	 */
	private static final String MAP_NAME = Const.INN;
	
    /**
     * 客栈背景图
     */
    private static Image IMG_INN;

    /**
     * 偏移量
     */
    private static final int SHIFT_LENGTH = 5;

    /**
     * 李逍遥角色
     */
    private LXY lxy = new LXY();

    /**
     * x和y轴位移
     */
    private int xShift, yShift;

    /**
     * 是否靠近李家村
     */
    private boolean isCloseToVillage;

    /*女孩*/
    private static Image[] IMG_NH = new Image[8];
    /*是否往右走*/
    private boolean isRight = true;
    /*图片下标*/
    private static int NH_IMG_INDEX = 0;
    /*x坐标*/
    private static int NH_X = 200;
    /*y坐标*/
    private static int NH_Y = 300;
    /*终点x坐标*/
    private static final int NH_END_X = 340;

    // 静态代码块 构造代码块
    static {
        try {
            IMG_INN = ImageIO.read(new File("img\\客栈\\0.png"));
            for (int i = 0; i < IMG_NH.length; i++) {
                IMG_NH[i] = ImageIO.read(new File("img\\女孩\\" + i + ".jpg"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public InnMap() {
        run();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(IMG_INN, 0 - xShift, 0 - yShift, null);
        //方法连动 通过李家村的paint方法 调用李逍遥的paint方法
        lxy.paint(g);
        int[] xpoints = {283 - xShift, 209 - xShift, 196 - xShift, 259 - xShift};
        int[] ypoints = {343 - yShift, 369 - yShift, 329 - yShift, 313 - yShift};
        //判断李逍遥是否靠近客栈
        Graphics2D g2d = (Graphics2D) g;
        isCloseToVillage = g2d.hit(new Rectangle(406, 374, 50, 50), new Polygon(xpoints, ypoints, xpoints.length), true);
        g.drawImage(IMG_NH[NH_IMG_INDEX], NH_X, NH_Y, 40, 100, null);
    }

    @Override
    public String keyPressed(KeyEvent e) {
        lxy.keyPressed(e);
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                yShift += SHIFT_LENGTH;
                break;
            case KeyEvent.VK_UP:
                yShift -= SHIFT_LENGTH;
                break;
            case KeyEvent.VK_LEFT:
                xShift -= SHIFT_LENGTH;
                break;
            case KeyEvent.VK_RIGHT:
                xShift += SHIFT_LENGTH;
                break;
        }

        //重绘
        repaint();
        //判断 如果 isCloseToVillage 为true 表明 李逍遥从客栈向李家村靠近
        return isCloseToVillage ? Const.VILLAGE_LI : null;
    }

    public void run() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (NH_X >= NH_END_X) {
                        isRight = false;
                        NH_IMG_INDEX = 4;
                    } else if (NH_X <= 200) {
                        isRight = true;
                        NH_IMG_INDEX = 0;
                    }
                    if (isRight) {
                        NH_X += 20;
                        NH_IMG_INDEX = (NH_IMG_INDEX + 1) > 3 ? 0 : (NH_IMG_INDEX + 1);
                    } else {
                        NH_X -= 20;
                        NH_IMG_INDEX = (NH_IMG_INDEX + 1) > 7 ? 4 : (NH_IMG_INDEX + 1);
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //重绘
                    repaint();
                }
            }
        }).start();
    }
}
