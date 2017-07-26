package com.pal.person;

import com.pal.enums.SkillEnum;
import com.pal.map.FightMap;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * BY
 * Created by heqianqian on 2017/7/26.
 */
public class BY {

    private static Image[] dlStateImgs = new Image[6];

    private static Image[] dlSkillImgs = new Image[6];

    private static Image[] smzhStateImgs = new Image[10];

    private static Image[] smzhSkillImgs = new Image[20];

    private static Image lxyImg = null;

    private int dlIndex = 0;

    private int smzhStateIndex = 0;

    private int smzhSkillIndedx = 0;

    static {
        try {
            for (int i = 0; i < dlStateImgs.length; i++) {
                dlStateImgs[i] = ImageIO.read(new File("img\\拜月地裂架势\\" + i + ".png"));
            }
            for (int i = 0; i < dlSkillImgs.length; i++) {
                dlSkillImgs[i] = ImageIO.read(new File("img\\拜月地裂\\" + i + ".png"));
            }
            for (int i = 0; i < smzhStateImgs.length; i++) {
                smzhStateImgs[i] = ImageIO.read(new File("img\\拜月三昧真火架势\\" + i + ".png"));
            }
            for (int i = 0; i < smzhSkillImgs.length; i++) {
                smzhSkillImgs[i] = ImageIO.read(new File("img\\拜月三昧真火\\" + i + ".png"));
            }
            lxyImg = ImageIO.read(new File("img\\李逍遥穿心架势\\0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SkillEnum paintDL(Graphics g) {
        g.drawImage(lxyImg, 600, 400, 80, 140, null);
        g.drawImage(dlStateImgs[dlIndex], 50, 300, 140, 150, null);
        g.drawImage(dlSkillImgs[dlIndex], 200, 300, 400, 300, null);
        if (dlIndex + 1 > 5) {
            return SkillEnum.JIANJ;
        } else {
            dlIndex = dlIndex + 1;
            return SkillEnum.DL;
        }
    }

    public SkillEnum paintSMZH(Graphics g) {
        g.drawImage(lxyImg, 600, 400, 80, 140, null);
        g.drawImage(smzhStateImgs[smzhStateIndex], 50, 300, 140, 150, null);
        g.drawImage(smzhSkillImgs[smzhSkillIndedx], 200, 300, 400, 300, null);
        smzhStateIndex = (smzhStateIndex + 1) > 9 ? 0 : (smzhStateIndex + 1);
        if (smzhSkillIndedx + 1 > 19) {
            return SkillEnum.NONE;
        } else {
            smzhSkillIndedx = smzhSkillIndedx + 1;
            return SkillEnum.SMZH;
        }
    }
}
