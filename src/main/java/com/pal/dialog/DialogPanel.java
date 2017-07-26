package com.pal.dialog;

import com.pal.consts.DataConfig;
import com.pal.map.Map;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

/**
 * DialogPanel
 * Created by heqianqian on 2017/7/26.
 */
public class DialogPanel extends Map {

    private static Image[] IMG_DIALOG = new Image[3];

    private int imgIndex = 0;

    static {
        try {
            for (int i = 0; i < IMG_DIALOG.length; i++) {
                IMG_DIALOG[i] = ImageIO.read(new File("img\\对话框\\客栈\\" + i + ".png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DialogPanel() {
        this.setSize(DataConfig.DIALOG_W, DataConfig.MAIN_FRAME_H);
        this.setLocation(DataConfig.DIALOG_X, DataConfig.DIALOG_Y);
    }

    public void paint(Graphics g) {
        g.drawImage(IMG_DIALOG[imgIndex], DataConfig.DIALOG_X, DataConfig.DIALOG_Y, DataConfig.DIALOG_W, DataConfig.DIALOG_H, null);
    }

    @Override
    public String keyPressed(KeyEvent e) {
        //空格键监听
        return null;
    }

    @Override
    public int mousePressed(MouseEvent e) {
        if (imgIndex + 1 > 2) {
            return -1;
        } else {
            imgIndex++;
        }
        return 0;
    }
}
