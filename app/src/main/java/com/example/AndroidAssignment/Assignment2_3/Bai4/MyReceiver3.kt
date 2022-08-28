package com.example.AndroidAssignment.Assignment2_3.Bai4

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyReceiver3 : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        var rcv3 = intent.getIntExtra("data",0)
        Log.d("rcv", "Receiver3: " + rcv3.toString())
    }
}