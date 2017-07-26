package com.pal.dialog;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * SkillPanel
 * Created by heqianqian on 2017/7/26.
 */
public class SkillPanel extends JPanel {

    private static Image IMG_SKILL;

    static {
        try {
            IMG_SKILL = ImageIO.read(new File("img\\技能界面\\0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SkillPanel() {
        this.setSize(300, 100);
        this.setLocation(200, 500);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(IMG_SKILL, 0, 0, 300, 100, null);
    }
}
