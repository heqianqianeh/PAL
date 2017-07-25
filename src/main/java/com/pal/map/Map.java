package com.pal.map;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * 场景类
 */
public abstract class Map extends JPanel {

    /**
     * 键盘监听事件
     */
    public abstract String keyPressed(KeyEvent e);
}
