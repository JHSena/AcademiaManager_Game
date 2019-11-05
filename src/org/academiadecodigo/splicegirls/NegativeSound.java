package org.academiadecodigo.splicegirls;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class NegativeSound {

    void playSound(String soundLocation) {
        try {
            File soundPath = new File("/Users/codecadet/Desktop/Workspace/finalGame/resources/242503__gabrielaraujo__failure-wrong-action.wav");

            if (soundPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();

            } else {
                System.out.println("BZZT ERROR BZZT NEGATIVE SOUND EFFECT FILE NOT FOooooouund.....d...bzzt... boop");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}