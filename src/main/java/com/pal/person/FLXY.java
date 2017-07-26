package com.pal.person;

import com.pal.enums.SkillEnum;
import com.pal.map.FightMap;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * FLXY
 * Created by heqianqian on 2017/7/26.
 */
public class FLXY {

    private static Image[] cxStateImgs = new Image[4];

    private static Image[] cxSkillImgs = new Image[26];

    private static Image[] wjjStateImgs = new Image[5];

    private static Image[] wjjSkillImgs = new Image[31];

    private static Image byImg = null;

    private int cxStateIndex = 0;

    private int cxSkillIndex = 0;

    private int wjjStateIndex = 0;

    private int wjjSkillIndex = 0;

    static {
        try {
            for (int i = 0; i < cxStateImgs.length; i++) {
                cxStateImgs[i] = ImageIO.read(new File("img\\李逍遥穿心架势\\" + i + ".png"));
            }
            for (int i = 0; i < cxSkillImgs.length; i++) {
                cxSkillImgs[i] = ImageIO.read(new File("img\\李逍遥万剑穿心\\" + i + ".png"));
            }
            for (int i = 0; i < wjjStateImgs.length; i++) {
                wjjSkillImgs[i] = ImageIO.read(new File("img\\李逍遥万剑决\\" + i + ".png"));
            }
            for (int i = 0; i < wjjStateImgs.length; i++) {
                wjjStateImgs[i] = ImageIO.read(new File("img\\李逍遥剑诀架势\\" + i + ".png"));
            }
            byImg = ImageIO.read(new File("img\\拜月谈话架势\\0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SkillEnum paintCX(Graphics g) {
        g.drawImage(byImg, 50, 300, 140, 150, null);
        g.drawImage(cxStateImgs[cxStateIndex], 600, 400, 80, 140, null);
        g.drawImage(cxSkillImgs[cxSkillIndex], 200, 300, 400, 300, null);
        cxStateIndex = (cxStateIndex + 1) > 3 ? 0 : (cxStateIndex + 1);
        if (cxSkillIndex + 1 > 25) {
            return SkillEnum.DL;
        } else {
            cxSkillIndex = cxSkillIndex + 1;
            return SkillEnum.WJCX;
        }
    }


    public SkillEnum paintWJJ(Graphics g) {
        g.drawImage(byImg, 50, 300, 140, 150, null);
        g.drawImage(wjjStateImgs[wjjStateIndex], 600, 400, 80, 140, null);
        g.drawImage(wjjSkillImgs[wjjSkillIndex], 200, 300, 400, 300, null);
        wjjStateIndex = (wjjStateIndex + 1) > 4 ? 0 : (wjjStateIndex + 1);
        if (wjjSkillIndex + 1 > 30) {
            return SkillEnum.SMZH;
        } else {
            wjjSkillIndex = wjjSkillIndex + 1;
            return SkillEnum.JIANJ;
        }
    }

}
