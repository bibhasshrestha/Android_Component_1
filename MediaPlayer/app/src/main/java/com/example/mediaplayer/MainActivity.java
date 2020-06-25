package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    private Button playButton;
    private Button pauseButton;
    //AudioManager audioManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = findViewById(R.id.play_button);
        pauseButton = findViewById(R.id.pause_button);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.memories);
        //mediaPlayer.start(); // no need to call prepare(); create() does that for you
        playButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.release();
    }

    private void releaseMediaPlayer(){
        if(mediaPlayer!=null){

            mediaPlayer.release();

            mediaPlayer=null;
        }
    }
}
