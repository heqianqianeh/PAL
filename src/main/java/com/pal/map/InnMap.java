package com.pal.map;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.pal.consts.Const;
import com.pal.listener.MapMouseListener;
import com.pal.person.LXY;
import com.pal.person.NH;
import com.pal.util.MouseUtil;

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

    /**
     * 客栈老板
     */
    private static Image innHost;

    static {
        try {
            IMG_INN = ImageIO.read(new File("img\\客栈\\0.png"));
            innHost = ImageIO.read(new File("img\\NPC\\inn_host.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public InnMap() {
        run();
        this.addMouseListener(new MapMouseListener(this));
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(IMG_INN, 0 - xShift, 0 - yShift, null);
        g.drawImage(innHost, 380 - xShift, 280 - yShift, null);
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

    @Override
    public void mousePressed(MouseEvent e) {
        if (MouseUtil.judgeMouse(370, 430, 270, 370, xShift, yShift)) {
            System.out.println("mousePressed: changeCursor");
            this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else {
            System.out.println("mousePressed: defaultCursor");
            this.setCursor(Cursor.getDefaultCursor());
        }
    }

    public void run() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //重绘
                    repaint();
                    //判断鼠标位置
                    judgeMouse();
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

    /**
     * 判断鼠标位置
     */
    private void judgeMouse() {
        if (MouseUtil.judgeMouse(700, 764, 400, 500, xShift, yShift)) {
            System.out.println("judgeMouse: changeCursor");
            this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else {
            this.setCursor(Cursor.getDefaultCursor());
        }
    }
}
