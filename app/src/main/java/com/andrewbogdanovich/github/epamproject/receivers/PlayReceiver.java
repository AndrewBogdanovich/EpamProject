package com.andrewbogdanovich.github.epamproject.receivers;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.andrewbogdanovich.github.epamproject.services.PlayerService;

public class PlayReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context, PlayerService.class));
    }
}
