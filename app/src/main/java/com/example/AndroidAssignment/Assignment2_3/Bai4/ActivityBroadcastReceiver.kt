package com.example.AndroidAssignment.Assignment2_3.Bai4

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.kotlinassignment.R

class ActivityBroadcastReceiver : AppCompatActivity() {
    var Rcv1 : MyReceiver1 = MyReceiver1()
    var Rcv2 : MyReceiver2 = MyReceiver2()
    var Rcv3 : MyReceiver3 = MyReceiver3()
    var Rcv4 : MyReceiver4 = MyReceiver4()
    var Rcv5 : MyReceiver5 = MyReceiver5()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_receiver)
        var btn = findViewById<Button>(R.id.btnSendData)
        btn.setOnClickListener {
            var data = (1..5).random()
            var intent = Intent()
            intent.action = "com.example.AndroidAssignment.Assignment2_3.Bai4.MyReceiver"
            intent.putExtra("data",data)
            sendOrderedBroadcast(intent,null,object :BroadcastReceiver(){
                override fun onReceive(p0: Context?, p1: Intent?) {
                    Log.d("aaa","Finish")
                }
            }, null, Activity.RESULT_OK,null,null)
        }

        var intentFilter = IntentFilter("com.example.AndroidAssignment.Assignment2_3.Bai4.MyReceiver")
        intentFilter.priority = 1
        registerReceiver(Rcv1,intentFilter)

        var intentFilter2 = IntentFilter("com.example.AndroidAssignment.Assignment2_3.Bai4.MyReceiver")
        intentFilter.priority = 2
        registerReceiver(Rcv2,intentFilter2)

        var intentFilter3 = IntentFilter("com.example.AndroidAssignment.Assignment2_3.Bai4.MyReceiver")
        intentFilter.priority = 3
        registerReceiver(Rcv3,intentFilter3)

        var intentFilter4 = IntentFilter("com.example.AndroidAssignment.Assignment2_3.Bai4.MyReceiver")
        intentFilter.priority = 4
        registerReceiver(Rcv4,intentFilter4)

        var intentFilter5 = IntentFilter("com.example.AndroidAssignment.Assignment2_3.Bai4.MyReceiver")
        intentFilter.priority = 5
        registerReceiver(Rcv5,intentFilter5)

    }

    override fun onStop() {
        super.onStop()

    }

}