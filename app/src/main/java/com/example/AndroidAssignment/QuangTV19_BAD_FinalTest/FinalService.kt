package com.example.AndroidAssignment.QuangTV19_BAD_FinalTest

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.AndroidAssignment.Assignment8.ForeGroundService
import com.example.AndroidAssignment.Assignment8.MainForeGround
import com.example.kotlinassignment.R
import kotlin.concurrent.thread

class FinalService : Service() {

    private val CHANNEL_ID = "ForegroundService Kotlin"

    var inputNumber :Int? = null

    companion object {
        fun startService(context: Context,number: Int) {
            val startIntent = Intent(context, FinalService::class.java)
            startIntent.putExtra("number", number)
            ContextCompat.startForegroundService(context, startIntent)
        }
        var flag = false

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        var sum = 0
        inputNumber = intent?.getIntExtra("number",0)
        for(i in 1 ..inputNumber!!){
            sum = sum + i
            if(i == inputNumber){
                flag = true
            }

        }
        sendMessageToActivity(sum, flag)

        if(flag==true) {

            createNotificationChannel()
            val notificationIntent = Intent(this, MainActivityFinal::class.java)
            val pendingIntent = PendingIntent.getActivity(
                this,
                0, notificationIntent, PendingIntent.FLAG_IMMUTABLE
            )
            val notification = NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("sum from to $inputNumber")
                .setContentText("$sum")
                .setSmallIcon(R.drawable.add)
                .setContentIntent(pendingIntent)
                .build()
            startForeground(1, notification)
        }
        Log.d("test", sum.toString())
        return START_NOT_STICKY
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(CHANNEL_ID, "Foreground Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT)
            val manager = getSystemService(NotificationManager::class.java)
            manager!!.createNotificationChannel(serviceChannel)
        }
    }

    fun sendMessageToActivity(number: Int,flag: Boolean)
    {
        var intent = Intent("numm");
        intent.putExtra("num", number);
        intent.putExtra("flag",flag)
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}