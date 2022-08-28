package com.example.AndroidAssignment.Assignment10

import android.graphics.Color
import android.graphics.Color.parseColor
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.kotlinassignment.R

class Fragment1Ass10 : Observer ,Fragment(){
    private var fragment1: FrameLayout? = null
    private var txtNum : TextView? = null
    private var handler = Handler()
    private var num = 0

    override fun update(number: Int) {
        num = number
        if(num < 0){
            txtNum?.setText(" ")
            fragment1!!.setBackgroundColor(Color.WHITE);
        }else
        {
            Toast.makeText(activity,"Play",Toast.LENGTH_SHORT).show()
            runnable.run()
        }

    }

    override fun stop() {
        handler.removeCallbacks(runnable)
        txtNum?.setText(" ")
        fragment1!!.setBackgroundColor(Color.WHITE);
    }

    private var runnable = object :Runnable{
        var i = 0
        override fun run() {
            if(i <= num && i%2 !=0) {
                txtNum?.setText("$i")
                fragment1!!.setBackgroundColor(Color.parseColor("#41ED34"))  //xanh
            }else if(i > num){
                txtNum?.setText(" ")
                fragment1!!.setBackgroundColor(Color.WHITE);
                handler.removeCallbacks(this)
            }
            i++
            handler.postDelayed(this,1000)
            Toast.makeText(activity,"run",Toast.LENGTH_SHORT).show()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fragment1_ass10, container, false)
        fragment1 = view.findViewById(R.id.fragment1Ass10)
        txtNum = view.findViewById(R.id.txtfragment1Ass10)

        return view
    }


}