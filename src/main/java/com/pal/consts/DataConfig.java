package com.pal.consts;

import com.pal.util.ConfigUtil;

/**
 * DataConfig
 * 数值配置类
 * Created by heqianqian on 2017/7/24.
 */
public interface DataConfig {

    /*================主窗体=================*/
    int MAIN_FRAME_X = ConfigUtil.getIntegerProperties("mainframe.x");
    int MAIN_FRAME_Y = ConfigUtil.getIntegerProperties("mainframe.y");
    int MAIN_FRAME_W = ConfigUtil.getIntegerProperties("mainframe.w");
    int MAIN_FRAME_H = ConfigUtil.getIntegerProperties("mainframe.h");

    /*================动画=================*/
    int MOVIE_W = ConfigUtil.getIntegerProperties("movie.w");
    int MOVIE_H = ConfigUtil.getIntegerProperties("movie.h");

    /*================菜单=================*/
    int MAIN_MENU_BG_W = ConfigUtil.getIntegerProperties("mainmenu.bg.w");
    int MAIN_MENU_BG_H = ConfigUtil.getIntegerProperties("mainmenu.bg.h");
    int MAIN_MENU_BTN_W = ConfigUtil.getIntegerProperties("mainmenu.btn.w");
    int MAIN_MENU_BTN_H = ConfigUtil.getIntegerProperties("mainmenu.btn.h");

     /*================对话框=================*/
     int DIALOG_W = ConfigUtil.getIntegerProperties("dialog.w");
    int DIALOG_H = ConfigUtil.getIntegerProperties("dialog.h");
    int DIALOG_X = ConfigUtil.getIntegerProperties("dialog.x");
    int DIALOG_Y = ConfigUtil.getIntegerProperties("dialog.y");

    /*================人物==================*/
    int LXY_X = ConfigUtil.getIntegerProperties("lxy.x");
    int LXY_Y = ConfigUtil.getIntegerProperties("lxy.y");
}
