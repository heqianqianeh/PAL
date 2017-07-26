package com.pal.map;

import com.pal.consts.Const;
import com.pal.person.LJCNPC;
import com.pal.person.LXY;
import com.pal.util.BounardCheckUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

/**
 * 李家村--场景
 */
public class LJCMap extends Map {

    /**
     * 李家村场景图
     */
    private static Image IMG_VILLAGE;

    private LJCNPC ljcnpc;

    /**
     * 李逍遥对象
     */
    private LXY lxy = new LXY();

    /**
     * 偏移量
     */
    private static final int SHIFT_LENGTH = 5;

    /**
     * 水平和垂直偏移量
     */
    private int xShift, yShift;

    /**
     * 判断李逍遥是否靠近客栈
     */
    private boolean isCloseToInn;

    static {
        try {
            IMG_VILLAGE = ImageIO.read(new File("img\\李家村\\0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public LJCMap() {
        run();
        ljcnpc = new LJCNPC(this);
        //鼠标监听事件的注册 必须放在李家村里 不能放在主场景里
        //this.addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        if (BounardCheckUtil.mapIsLoadLeft(0, -300, xShift)) {
            xShift += SHIFT_LENGTH;
        } else if (BounardCheckUtil.mapIsLoadHead(0, -200, yShift)) {
            yShift += SHIFT_LENGTH;
        } else if (BounardCheckUtil.mapIsLoadRight(1440, -300, xShift)) {
            xShift -= SHIFT_LENGTH;
        } else if (BounardCheckUtil.mapIsLoadBottom(1035, -200, yShift)) {
            yShift -= SHIFT_LENGTH;
        }

        g.drawImage(IMG_VILLAGE, -300 - xShift, -200 - yShift, null);
        ljcnpc.paint(g,xShift,yShift);
        //方法连动 通过李家村的paint方法 调用李逍遥的paint方法
        lxy.paint(g);
        int[] xpoints = {715 - xShift, 665 - xShift, 737 - xShift, 771 - xShift};
        int[] ypoints = {283 - yShift, 292 - yShift, 375 - yShift, 310 - yShift};
        //判断李逍遥是否靠近客栈
        Graphics2D g2d = (Graphics2D) g;
        isCloseToInn = g2d.hit(new Rectangle(414, 377, 50, 50), new Polygon(xpoints, ypoints, xpoints.length), true);
    }

    public void run() {
        //匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    repaint();
                }
            }
        }).start();
    }

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
        //从李家村靠近客栈
        return isCloseToInn ? Const.INN : null;
    }

    @Override
    public int mousePressed(MouseEvent e) {
        //TODO
        return 0;
    }

}
