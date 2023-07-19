package com.example.foregservcinandroid

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.telephony.SmsManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import com.example.foregservcinandroid.ui.theme.ForeGServcinAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ForeGServcinAndroidTheme {
                 Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Column() {

                        ActivityCompat.requestPermissions(this@MainActivity, arrayOf(Manifest.permission.SEND_SMS),6)

                        var smsManager: SmsManager

                        smsManager= SmsManager.getDefault()

                        Button(onClick = {
                         //   smsManager.sendTextMessage("8148580586",null,"Great Day!",null,null)

                            val i = Intent(applicationContext,DoingSth::class.java)
                            startService(i)
                            }) {
                            Text(text = "Start Service")
                        }
                        Button(onClick = {
                            val i = Intent(applicationContext,DoingSth::class.java)
                            stopService(i)
                        }) {

                            Text(text = "Stop Service")
                        }
                    }
                }
            }
        }
    }
}