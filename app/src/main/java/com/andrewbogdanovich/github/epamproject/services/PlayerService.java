package com.andrewbogdanovich.github.epamproject.services;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.app.Service;

import com.andrewbogdanovich.github.epamproject.R;

import javax.annotation.Nullable;


public class PlayerService extends Service {
    private MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        mediaPlayer = MediaPlayer.create(this, R.raw.napas);
        mediaPlayer.setLooping(false);
        super.onCreate();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        super.onDestroy();
    }
}
