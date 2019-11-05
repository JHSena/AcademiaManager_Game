package org.academiadecodigo.splicegirls;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class MusicPlayer {

    void playMusic(String musicLocation) {
        try
        {
            File musicPath = new File("/Users/codecadet/Desktop/Workspace/finalGame/resources/VOLUME_Spice_Girls_-_Wannabe.wav");

            if(musicPath.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);


            }
            else
            {
                System.out.println("BZZT ERROR BZZT SOUND FILE NOT FOooooouund.....d...bzzt... boop");
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }
}