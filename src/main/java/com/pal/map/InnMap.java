package com.pal.map;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.pal.consts.Const;
import com.pal.person.LXY;
import com.pal.person.NH;

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
     * 李逍遥角色
     */
    private NH nh = new NH(this);    
    
    /**
     * x和y轴位移
     */
    private int xShift, yShift;

    /**
     * 是否靠近李家村
     */
    private boolean isCloseToVillage;
    
    static {
    	try {
			IMG_INN = ImageIO.read(new File("img\\客栈\\0.png"));
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
        nh.paint(g);
        int[] xpoints = {283 - xShift, 209 - xShift, 196 - xShift, 259 - xShift};
        int[] ypoints = {343 - yShift, 369 - yShift, 329 - yShift, 313 - yShift};
        //判断李逍遥是否靠近客栈
        Graphics2D g2d = (Graphics2D) g;
        isCloseToVillage = g2d.hit(new Rectangle(406, 374, 50, 50), new Polygon(xpoints, ypoints, xpoints.length), true);
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

	public int getxShift() {
		return xShift;
	}

	public int getyShift() {
		return yShift;
	}
    
}
