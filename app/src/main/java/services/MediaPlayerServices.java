package services;

import android.content.Context;
import android.media.MediaPlayer;

import model.Song;

/**
 * Created by Naditha Harshana on 3/30/2018.
 */

public class MediaPlayerServices {

    private MediaPlayer mediaplayer;
    private Song song;

    public MediaPlayerServices(MediaPlayer mediaplayer, Song song) {
        this.mediaplayer = mediaplayer;
        this.song = song;
    }

    public void CreatePlayer(Context context, Song song) {
        mediaplayer = mediaplayer.create(context, song.getSong());
    }

    public void play() {
        mediaplayer.start();
    }

    public void pause() {
        mediaplayer.pause();
    }

    public void stop() {
        mediaplayer.stop();
    }

    public void release() {
        mediaplayer.release();
    }


}
