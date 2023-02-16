package com.example.services;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class FService extends Service {
    MediaPlayer mp;
    public FService() {
        super();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mp = MediaPlayer.create(getApplicationContext(),R.raw.song);
        mp.start();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel nc=new NotificationChannel(
                    "Foreground Service",
                    "Foreground Service",
                    NotificationManager.IMPORTANCE_LOW
            );
            getSystemService(NotificationManager.class).createNotificationChannel(nc);
            Notification.Builder b= new Notification.Builder(this,"Foreground Service")
                    .setContentText("Service is running")
                    .setContentTitle("Service demo");
            startForeground(1000,b.build());
        }
        else
        {
            Toast.makeText(this, "Foreground Service not Supported", Toast.LENGTH_SHORT).show();
        }


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        mp.stop();
        mp.release();
        super.onDestroy();
    }
    @Override
    public boolean stopService(Intent name) {

        return super.stopService(name);

    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
