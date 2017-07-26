package com.pal.main;

import javax.swing.*;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

/**
 * MusicFrame
 * Created by heqianqian on 2017/7/26.
 */
public class MusicFrame extends JFrame {

    public MusicFrame() {
        this.setBounds(100, 100, 400, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        AudioClip audio = null;
        try {
            audio = JApplet.newAudioClip(new File("music\\w.wav").toURL());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        audio.play();//播放音乐
        this.setVisible(true);
    }


    public void loopMusic(){

    }

    public static void main(String[] args) {
        new MusicFrame();
    }
}
