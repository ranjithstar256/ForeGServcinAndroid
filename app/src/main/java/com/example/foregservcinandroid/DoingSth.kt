package com.example.foregservcinandroid

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import kotlinx.coroutines.NonCancellable.start

// long running bg tasks = upl , dwn , ply bg

class DoingSth : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intt: Intent?, flags: Int, startId: Int): Int
    {
        var inte = Intent(applicationContext,MainActivity::class.java)
        var pendin = PendingIntent.getActivity(
            applicationContext,
            0,
            inte,
            PendingIntent.FLAG_IMMUTABLE
        )
        val notificationBuilder = NotificationCompat.Builder(applicationContext, "101")
            .setContentTitle("music playing")
            .setContentText("03:30")
            .setContentIntent(pendin)
            .setSmallIcon(android.R.drawable.ic_media_play)
            .build()

        startForeground(6,notificationBuilder)

        return super.onStartCommand(intt, flags, startId)
    }



}