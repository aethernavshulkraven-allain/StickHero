package com.example.stickhero;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;

public class MusicPlayer implements Player, Runnable {

    public String getSong() {
        return "mujic.mp3";
    }

    MediaPlayer mediaPlayer;


    @Override
    public void run() {
        String ms = getSong();
        Media h = new Media(Paths.get(ms).toUri().toString());
        mediaPlayer = new MediaPlayer(h);
        mediaPlayer.play();
    }
}

class Song1Player extends MediaDecorator implements Runnable {
    public Song1Player(Player decorator) {
        super(decorator);
    }

    public void run(){


    }

    @Override
    public String getSong() {
        return "music2.mp3";  // Change the song for Song1Player
    }
}

class Song2Player extends MediaDecorator implements Runnable {
    public Song2Player(Player decorator) {
        super(decorator);
    }

    @Override
    public String getSong() {
        return "music3.mp3";  // Change the song for Song2Player
    }

    public void run(){

    }
}

class MediaDecorator implements Player {
    private Player player;

    public MediaDecorator(Player player) {
        this.player = player;
    }

    @Override
    public String getSong() {
        return player.getSong();
    }
}

interface Player {


    String getSong();
}
