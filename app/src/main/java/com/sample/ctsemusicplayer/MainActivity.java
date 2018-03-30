package com.sample.ctsemusicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import model.Song;
import services.MediaPlayerServices;

public class MainActivity extends AppCompatActivity {

    View view;
    Song song;
    ViewHolder vh = new ViewHolder();
    MediaPlayer mediaplayer;
    MediaPlayerServices mps;
    Boolean isSongSet = false;
    Boolean isPause = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        song = new Song("Sanda Midulata Enawa", "Amal Perera Cover", R.raw.sandamidulataenawa);

    }

    @Override
    protected void onStart() {
        super.onStart();

        vh.song = (TextView) findViewById(R.id.song);
        vh.artist = (TextView) findViewById(R.id.singer);
        vh.play = (ImageView) findViewById(R.id.PlayBtn);
        vh.song.setText(song.getName());
        vh.artist.setText(song.getSinger());
        mps = new MediaPlayerServices(mediaplayer, song);
        mps.CreatePlayer(this, song);
       //mediaplayer = mediaplayer.create(this, song.getSong());
    }

    @Override
    protected void onResume() {
        super.onResume();

        vh.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isSongSet){
                    if(!isPause) {
                        mps.play();
                        vh.play.setImageResource(R.drawable.ic_pause_black_36dp);
                        isSongSet = true;
                    } else {
                        vh.play.setImageResource(R.drawable.ic_pause_black_36dp);
                        mps.play();
                    }
                } else {
                    if(isPause) {
                        vh.play.setImageResource(R.drawable.ic_pause_black_36dp);
                        mps.play();
                        isPause = false;
                    } else {
                        mps.pause();
                        vh.play.setImageResource(R.drawable.ic_play_arrow_black_36dp);
                        isPause = true;
                    }
                }

            }
        });
    }

    private class ViewHolder {
        ImageView play;
        TextView song, artist;
    }
}
