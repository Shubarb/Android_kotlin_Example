package com.example.AndroidAssignment.Assignment2_3.Bai4

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyReceiver4 : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        var rcv4 = intent.getIntExtra("data",0)
        Log.d("rcv", "Receiver4: " + rcv4.toString())
    }
}