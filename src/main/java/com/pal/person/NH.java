package com.pal.person;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.pal.map.InnMap;

/**
 * 客栈女孩--人物
 */
public class NH {
	private InnMap innMap;
    /*女孩素材*/
    private final static Image[] IMG_RIGHT_DOWN = new Image[4];

    /*是否往右走*/
    private boolean isRightDown = true;
    /*图片下标*/
    private static int NH_IMG_INDEX = 0;
    /*x坐标*/
    private static int NH_START_X_FIRST = 420;
    /*y坐标*/
    private static int NH_START_Y_FIRST = 88;
    /*终点x坐标*/
    private static final int NH_END_X_FIRST = 538;
    /*终点y坐标*/
    private static final int NH_END_Y_FIRST = 251;
    
    static {
        try {
            for (int i = 0; i < IMG_RIGHT_DOWN.length; i++) {
            	IMG_RIGHT_DOWN[i] = ImageIO.read(new File("img\\女孩右下\\" + i + ".jpg"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public NH(InnMap innMap) {
    	this.innMap = innMap;
	}


	public void paint(Graphics g) {
    	 if (NH_START_X_FIRST >= NH_END_X_FIRST && NH_START_Y_FIRST >= NH_END_Y_FIRST) {
             isRightDown = false;
         }
    	 
         if (isRightDown) {
             NH_START_X_FIRST += 2;
             NH_START_Y_FIRST += 3;
             NH_IMG_INDEX = (NH_IMG_INDEX + 1) > 3 ? 0 : (NH_IMG_INDEX + 1);
         }
         
    	 g.drawImage(IMG_RIGHT_DOWN[NH_IMG_INDEX], NH_START_X_FIRST-innMap.getxShift(), NH_START_Y_FIRST-innMap.getyShift(), 40, 100, null);
    }    

}
