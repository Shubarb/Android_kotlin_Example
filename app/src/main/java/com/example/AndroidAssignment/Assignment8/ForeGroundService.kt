package com.example.AndroidAssignment.Assignment8

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.example.kotlinassignment.R

class ForeGroundService : Service() {

    private val CHANNEL_ID = "ForegroundService Kotlin"
    private var mediaPlayer: MediaPlayer? = null
//    private var music: Int? = null


    companion object {
        fun startService(context: Context, name: String, singer: String,time: Int,music: Int) {
            val startIntent = Intent(context, ForeGroundService::class.java)
            startIntent.putExtra("name", name)
            startIntent.putExtra("singer", singer)
            startIntent.putExtra("time",time)
            startIntent.putExtra("music",music)
//            context.stopService(startIntent)
            ContextCompat.startForegroundService(context, startIntent)
        }
        fun stop(context: Context){
            val stopIntent = Intent(context, ForeGroundService::class.java)
            context.stopService(stopIntent)
        }

        fun pause(context: Context,msg: String,flagser:Boolean) {

            Toast.makeText(context,"$msg",Toast.LENGTH_SHORT).show()

            val startIntent = Intent(context, ForeGroundService::class.java)
            startIntent.putExtra("flag", flagser)
            ContextCompat.startForegroundService(context, startIntent)
            if(flagser == false)context.stopService(startIntent)
        }
        fun nexts(context: Context, msg: String){
            Toast.makeText(context,"$msg",Toast.LENGTH_SHORT).show()
        }
        fun prevs(context: Context, msg: String){
            Toast.makeText(context,"$msg",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate() {
        super.onCreate()
//        val intent = Intent()
//        var music = intent.getIntExtra("music",0)
        mediaPlayer = MediaPlayer.create(applicationContext,R.raw.victory)
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val inputName = intent?.getStringExtra("name")
        val inputSinger = intent?.getStringExtra("singer")
        val flag = intent?.getBooleanExtra("flag",true)


        createNotificationChannel()
        val notificationIntent = Intent(this, MainForeGround::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0, notificationIntent, PendingIntent.FLAG_IMMUTABLE
        )
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle(inputName)
            .setContentText(inputSinger)
            .setSmallIcon(R.drawable.girl2)
            .setContentIntent(pendingIntent)
            .build()
        startForeground(1, notification)

        if(flag == true) {
            mediaPlayer?.start()

        }else {
            mediaPlayer?.pause()
        }

        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(CHANNEL_ID, "Foreground Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT)
            val manager = getSystemService(NotificationManager::class.java)
            manager!!.createNotificationChannel(serviceChannel)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }

}