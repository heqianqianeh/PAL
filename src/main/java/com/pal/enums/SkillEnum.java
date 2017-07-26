package com.pal.enums;

/**
 * SkillEnum
 * Created by heqianqian on 2017/7/26.
 */
public enum SkillEnum {


    SMZH(0), DL(1), WJCX(2), JIANJ(3),NONE(-1);

    private int index;

    SkillEnum(int index) {
        this.index = index;
    }
}
