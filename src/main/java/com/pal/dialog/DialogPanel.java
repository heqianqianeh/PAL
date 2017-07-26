package com.pal.dialog;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * DialogPanel
 * Created by heqianqian on 2017/7/26.
 */
public class DialogPanel {

    private static final int IMG_W = 782;
    private static final int IMG_H = 198;

    private static Image[] IMG_DIALOG = new Image[10];

    private int imgIndex = 0;

    static {
        try {
            for (int i = 0; i < IMG_DIALOG.length; i++) {
                //TODO
                IMG_DIALOG[i] = ImageIO.read(new File("img\\对话框\\1.png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //public DialogPanel() {
    //    this.setSize(782, 198);
    //    this.setLocation(0,363);
    //}

    public void paint(Graphics g) {
        System.out.println("绘制对话框");
        //绘制对话框
        g.drawImage(IMG_DIALOG[imgIndex], 0, 363, IMG_W, IMG_H, null);
    }
}
