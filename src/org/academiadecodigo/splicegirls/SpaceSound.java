package org.academiadecodigo.splicegirls;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SpaceSound {

    void playSpace(String soundLocation) {
        try {
            File soundPath = new File("/Users/codecadet/Desktop/Workspace/finalGame/resources/Confirm 1.wav");

            if (soundPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();

            } else {
                System.out.println("BZZT ERROR BZZT SPACE EFFECT FILE NOT FOooooouund.....d...bzzt... boop");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}