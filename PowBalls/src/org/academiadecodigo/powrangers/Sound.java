package org.academiadecodigo.powrangers;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.net.URL;

import static jdk.jfr.internal.JVM.flush;

public class Sound {
    Clip clip;
    URL[] soundURl = new URL[100];
    File[] soundList = new File[100];
    private boolean playing= false;

    public Sound() {
        soundList[0] = new File("ballCrash.wav");
        soundList[1] = new File("ballSlap.wav");
        soundList[2] = new File("crashBall.wav");
        soundList[3] = new File("decide.wav");
        soundList[4] = new File("gameOverFanny.wav");
        soundList[5] = new File("gameover.wav");
        soundList[6] = new File("eletricpop.wav");
        soundList[7] = new File("outraMerda.wav");
        soundList[8] = new File("explode.wav");
        soundList[9] = new File("explode2.wav");
        soundList[10] = new File("resources/bottle-cap-fall-86300.wav");
        soundList[11] = new File("resources/bottle-smash-101001.wav");
        soundList[12] = new File("resources/crash-glass-sound-effect-24-11503.wav");
        soundList[13] = new File("resources/glass-bottle-open-86299.wav");
        soundList[14] = new File("resources/glass-clink-57538.wav");
        soundList[15] = new File("resources/huge-slap-in-the-face-6859.wav");
        soundList[16] = new File("resources/opening-beer-can-6336.wav");
        soundList[17] = new File("resources/ough-47202.wav");
        soundList[18] = new File("resources/person-knocked-down-14798.wav");
        soundList[19] = new File("resources/the-crumpled-can-of-beer-87340.wav");
        soundList[20] = new File("resources/BeepBox-Song.wav");
        soundList[21] = new File("resources/converted_usable.wav");

        System.out.println(soundList[1]);
    }

    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundList[i]);

            clip = AudioSystem.getClip();
            clip.open(ais);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public void play() {
        clip.start();
        playing = true;
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
        playing = false;
    }

    public void playMusic(int i) {
        play();
        setFile(i);
    }

    public void stopMusic() {
        stop();
    }

    public void playSoundEfect(int i) {
        setFile(i);
        play();
    }

    public void drainMusic(){
        clip.drain();
    }
    public void flushMusic(){
        clip.flush();
    }
    public void musicReset(){
        clip.setMicrosecondPosition(0);

        clip.close();
        clip.flush();
    }

}
