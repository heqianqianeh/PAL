package com.pal.listener;

import com.pal.map.Map;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * MapMouseListener
 * Created by heqianqian on 2017/7/25.
 */
public class MapMouseListener extends MouseAdapter {

    private Map map;


    public MapMouseListener(Map map) {
        this.map = map;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        map.mousePressed(e);
    }
}
