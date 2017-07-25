package com.pal.main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.pal.consts.DataConfig;
import com.pal.listener.MMouseListener;

/**
 * MainMenu
 * 主菜单
 * Created by heqianqian on 2017/7/24.
 */
public class MainMenu extends JPanel {

    /**
     * 按钮起始x坐标
     */
    private static final int BTN_X_INDEX = 40;

    /**
     * 按钮起始y坐标
     */
    private static final int BTN_Y_INDEX = 165;

    /**
     * 按钮间距
     */
    private static final int BTN_PADDING = 50;

    /**
     * 主菜单背景
     */
    private static Image IMG_MENU_BG = null;

    /**
     * 新的游戏图片
     */
    private static Image[] IMG_NEW_GAME = new Image[2];

    /**
     * 旧的回忆图片
     */
    private static Image[] IMG_OLD_MEMORY = new Image[2];

    private static JButton btn = new JButton();

    /**
     * 存档图片
     */
    private static Image[] IMG_SAVE_GAME = new Image[2];


    static {
        try {
            //初始化主菜单背景图
            IMG_MENU_BG = ImageIO.read(new File("img\\主菜单\\RoleInfo.png"));
            for (int i = 0; i < 2; i++) {
                IMG_NEW_GAME[i] = ImageIO.read(new File("img\\主菜单\\NewGame" + (i + 1) + ".png"));
                IMG_OLD_MEMORY[i] = ImageIO.read(new File("img\\主菜单\\OldGame" + (i + 1) + ".png"));
                IMG_SAVE_GAME[i] = ImageIO.read(new File("img\\主菜单\\SaveGame" + (i + 1) + ".png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        //绘制菜单背景
        g.drawImage(IMG_MENU_BG, 0, 0,
                DataConfig.MAIN_FRAME_W, DataConfig.MAIN_FRAME_H,
                0, 0, DataConfig.MAIN_MENU_BG_W, DataConfig.MAIN_MENU_BG_H,
                null);
        //绘制图标按钮 width 186 34
        //new game
        g.drawImage(IMG_NEW_GAME[0], BTN_X_INDEX, BTN_Y_INDEX, BTN_X_INDEX + 700, BTN_Y_INDEX + DataConfig.MAIN_MENU_BG_H, 0, 0, DataConfig.MAIN_MENU_BG_W, DataConfig.MAIN_MENU_BG_H, null);
        //old game
        g.drawImage(IMG_OLD_MEMORY[0], BTN_X_INDEX, BTN_Y_INDEX + BTN_PADDING, BTN_X_INDEX + 700, BTN_Y_INDEX + DataConfig.MAIN_MENU_BG_H + BTN_PADDING, 0, 0, DataConfig.MAIN_MENU_BG_W, DataConfig.MAIN_MENU_BG_H, null);
        ////save game
        g.drawImage(IMG_SAVE_GAME[0], BTN_X_INDEX, BTN_Y_INDEX + BTN_PADDING * 2, BTN_X_INDEX + 700, BTN_Y_INDEX + DataConfig.MAIN_MENU_BG_H + (BTN_PADDING * 3), 0, 0, DataConfig.MAIN_MENU_BG_W, DataConfig.MAIN_MENU_BG_H, null);
    }

    public MainMenu() {
    	//鼠标监听事件注册
        this.addMouseListener(new MMouseListener(this));
    }

    public void mousePressed(MouseEvent e) {
    	if (e.getX() >= BTN_X_INDEX && e.getX() <= BTN_X_INDEX+700) {
			if (e.getY() >= 165 && e.getY() <= 197) {
		        //new game
				this.getGraphics().drawImage(IMG_NEW_GAME[1], BTN_X_INDEX, BTN_Y_INDEX, BTN_X_INDEX + 700, BTN_Y_INDEX + DataConfig.MAIN_MENU_BG_H, 0, 0, DataConfig.MAIN_MENU_BG_W, DataConfig.MAIN_MENU_BG_H, null);
				//old game
				this.getGraphics().drawImage(IMG_OLD_MEMORY[0], BTN_X_INDEX, BTN_Y_INDEX + BTN_PADDING, BTN_X_INDEX + 700, BTN_Y_INDEX + DataConfig.MAIN_MENU_BG_H + BTN_PADDING, 0, 0, DataConfig.MAIN_MENU_BG_W, DataConfig.MAIN_MENU_BG_H, null);
				////save game
				this.getGraphics().drawImage(IMG_SAVE_GAME[0], BTN_X_INDEX, BTN_Y_INDEX + BTN_PADDING * 2, BTN_X_INDEX + 700, BTN_Y_INDEX + DataConfig.MAIN_MENU_BG_H + (BTN_PADDING * 3), 0, 0, DataConfig.MAIN_MENU_BG_W, DataConfig.MAIN_MENU_BG_H, null);
			} else if (e.getY() >= 215 && e.getY() <= 246) {
				//new game
				this.getGraphics().drawImage(IMG_NEW_GAME[0], BTN_X_INDEX, BTN_Y_INDEX, BTN_X_INDEX + 700, BTN_Y_INDEX + DataConfig.MAIN_MENU_BG_H, 0, 0, DataConfig.MAIN_MENU_BG_W, DataConfig.MAIN_MENU_BG_H, null);
				//old game
				this.getGraphics().drawImage(IMG_OLD_MEMORY[1], BTN_X_INDEX, BTN_Y_INDEX + BTN_PADDING, BTN_X_INDEX + 700, BTN_Y_INDEX + DataConfig.MAIN_MENU_BG_H + BTN_PADDING, 0, 0, DataConfig.MAIN_MENU_BG_W, DataConfig.MAIN_MENU_BG_H, null);
				////save game
				this.getGraphics().drawImage(IMG_SAVE_GAME[0], BTN_X_INDEX, BTN_Y_INDEX + BTN_PADDING * 2, BTN_X_INDEX + 700, BTN_Y_INDEX + DataConfig.MAIN_MENU_BG_H + (BTN_PADDING * 3), 0, 0, DataConfig.MAIN_MENU_BG_W, DataConfig.MAIN_MENU_BG_H, null);
			} else if (e.getY() >= 265 && e.getY() <= 303) {
				//new game
				this.getGraphics().drawImage(IMG_NEW_GAME[0], BTN_X_INDEX, BTN_Y_INDEX, BTN_X_INDEX + 700, BTN_Y_INDEX + DataConfig.MAIN_MENU_BG_H, 0, 0, DataConfig.MAIN_MENU_BG_W, DataConfig.MAIN_MENU_BG_H, null);
				//old game
				this.getGraphics().drawImage(IMG_OLD_MEMORY[0], BTN_X_INDEX, BTN_Y_INDEX + BTN_PADDING, BTN_X_INDEX + 700, BTN_Y_INDEX + DataConfig.MAIN_MENU_BG_H + BTN_PADDING, 0, 0, DataConfig.MAIN_MENU_BG_W, DataConfig.MAIN_MENU_BG_H, null);
				////save game
				this.getGraphics().drawImage(IMG_SAVE_GAME[1], BTN_X_INDEX, BTN_Y_INDEX + BTN_PADDING * 2, BTN_X_INDEX + 700, BTN_Y_INDEX + DataConfig.MAIN_MENU_BG_H + (BTN_PADDING * 3), 0, 0, DataConfig.MAIN_MENU_BG_W, DataConfig.MAIN_MENU_BG_H, null);
			}
		}
    }



}
