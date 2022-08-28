package com.example.AndroidAssignment.QuangTV19_BAD_FinalTest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.AndroidAssignment.Assignment6.Bai1.FragmentDialog
import com.example.AndroidAssignment.Assignment8.ForeGroundService
import com.example.AndroidAssignment.Assignment8.PlayMusicFragment
import com.example.AndroidAssignment.QuangTV19_BAD_FinalTest.FinalService.Companion.flag
import com.example.kotlinassignment.R

class MainActivityFinal : AppCompatActivity(),SendService {
    private lateinit var mfragmentManager : FragmentManager
    private var mes :Int? = null
    private var flag :Boolean? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_final)
        mfragmentManager = supportFragmentManager

        FinalService.startService(this,1000000)

        LocalBroadcastManager.getInstance(this).registerReceiver(
            mMessageReceiver, IntentFilter("numm")
        )
        Toast.makeText(this,"$mes", Toast.LENGTH_SHORT).show()
        if(flag == true) {
            var fragment = DialogFragmentFinal()
            mfragmentManager = supportFragmentManager
            val bundle = Bundle()
            bundle.putInt("number", mes!!)
            fragment.arguments = bundle
            val fragmentTransaction = mfragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.fram, fragment)
            fragmentTransaction.commit()
        }
    }

    private val mMessageReceiver  = object : BroadcastReceiver(){
        override fun onReceive(p0: Context?, p1: Intent?) {
            mes = p1!!.getIntExtra("num", 0)
            flag = p1.getBooleanExtra("flag", true)

        }
    }
    override fun sendDialog1(msg: Int) {
    }
}