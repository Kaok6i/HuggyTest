package com.example.huggytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.media.MediaPlayer;

import android.view.View;

import android.widget.ImageButton;

import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButton;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    Play();
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    Stop();
                }
                return true;
            }
        });
    }

    public void Play() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.soundhuggy);
        }
        mediaPlayer.start();
    }

    public void Stop() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
