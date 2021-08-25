package com.example.audioset;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioManager=(AudioManager)getSystemService(AUDIO_SERVICE);
        int currentVolume=audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        int maxVol = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        MediaPlayer mp = MediaPlayer.create(this,R.raw.aud);


        Button playButton= (Button)findViewById(R.id.playbutton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();

            }
        });

        Button pauseButton= (Button)findViewById(R.id.pauseButton);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();;
            }
        });

        SeekBar volc=(SeekBar)findViewById(R.id.seekBar);
        volc.setMax(maxVol);
        volc.setProgress(currentVolume);
        volc.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
               audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,i,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar scrubSeekbar = (SeekBar)findViewById(R.id.ScrubseekBar);

        scrubSeekbar.setMax(mp.getDuration());

        scrubSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mp.seekTo(i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                mp.pause();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mp.start();

            }
        });

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                scrubSeekbar.setProgress(mp.getCurrentPosition());
            }
        },0,300);


    }
}