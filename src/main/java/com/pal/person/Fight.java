package com.pal.person;

/**
 * Fight
 * Created by heqianqian on 2017/7/26.
 */
public class Fight {

    private boolean isLXY = false;

    public synchronized void lxyFight() {
        try {
            if (!isLXY) {
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void byFight() {
        try {
            if (isLXY) {
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
