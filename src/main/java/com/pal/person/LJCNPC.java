package com.pal.person;

import com.pal.map.Map;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * LJCNPC
 * Created by heqianqian on 2017/7/26.
 */
public class LJCNPC {
    /**
     * 阿旺婶
     */
    private static Image[] IMG_AWANGSAO = new Image[17];
    /**
     * 阿朱
     */
    private static Image[] IMG_AZHU = new Image[6];
    /**
     * 跳绳
     */
    private static Image[] IMG_TS = new Image[4];
    /**
     * 小鸡
     */
    private static Image[] IMG_XJI = new Image[2];
    /**
     * 小小鸡
     */
    private static Image[] IMG_XXJ = new Image[2];
    /**
     * 母鸡
     */
    private static Image[] IMG_MJ = new Image[6];
    /**
     * 定义阿旺婶的数组索引值
     */
    private int awIndex;
    /**
     * 阿朱的数组索引值
     */
    private int azIndex;
    /**
     * 跳绳索引
     */
    private int tsIndex;
    /**
     * 小鸡索引
     */
    private int xjIndex;
    /**
     * 小小鸡索引
     */
    private int xxjIndex;
    /**
     * 母鸡索引
     */
    private int mjIndex;

    private Map map;

    static {
        try {
            for (int i = 0; i < IMG_AWANGSAO.length; i++) {
                IMG_AWANGSAO[i] = ImageIO.read(new File("img\\阿旺婶\\" + i + ".png"));
            }
            for (int i = 0; i < IMG_AZHU.length; i++) {
                IMG_AZHU[i] = ImageIO.read(new File("img\\阿珠喂鸡\\" + i + ".png"));
            }
            for (int i = 0; i < IMG_TS.length; i++) {
                IMG_TS[i] = ImageIO.read(new File("img\\跳绳\\" + i + ".png"));
            }
            for (int i = 0; i < IMG_XJI.length; i++) {
                IMG_XJI[i] = ImageIO.read(new File("img\\小鸡\\" + i + ".png"));
            }
            for (int i = 0; i < IMG_XXJ.length; i++) {
                IMG_XXJ[i] = ImageIO.read(new File("img\\小小鸡\\" + i + ".png"));
            }
            for (int i = 0; i < IMG_MJ.length; i++) {
                IMG_MJ[i] = ImageIO.read(new File("img\\母鸡\\" + i + ".png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public LJCNPC(Map map) {
        this.map = map;
        run();
    }

    public void run() {
        new Thread(new Runnable() {
            @Override
            public void run() {
               while (true){
                   awIndex = (azIndex + 1) > 16 ? 0 : (azIndex + 1);
                   //阿朱图片下标
                   azIndex = (azIndex + 1) > 5 ? 0 : (azIndex + 1);
                   // 小鸡图片
                   xjIndex = (xjIndex + 1) > 1 ? 0 : (xjIndex + 1);
                   xxjIndex = (xxjIndex + 1) > 1 ? 0 : (xxjIndex + 1);
                   tsIndex = (tsIndex + 1) > 1 ? 0 : (tsIndex + 1);
                   mjIndex = (mjIndex + 1) > 4 ? 0 : (mjIndex + 1);

                   try {
                       Thread.sleep(200);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }

                   map.validate();
                   map.repaint();
               }
            }
        }).start();
    }


    public void paint(Graphics g, int xShift, int yShift) {
        g.drawImage(IMG_AWANGSAO[awIndex], 380 - xShift, 300 - yShift, null);
        g.drawImage(IMG_AZHU[azIndex], 600 - xShift, 300 - yShift, null);
        g.drawImage(IMG_TS[tsIndex], 200 - xShift, 300 - yShift, null);
        g.drawImage(IMG_XJI[xjIndex], 740 - xShift, 420 - yShift, null);
        g.drawImage(IMG_XXJ[xxjIndex], 690 - xShift, 460 - yShift, null);
        g.drawImage(IMG_MJ[mjIndex], 630 - xShift, 390 - yShift, null);
    }
}
