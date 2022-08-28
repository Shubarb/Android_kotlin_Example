package com.example.AndroidAssignment.Assignment10

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import com.example.kotlinassignment.R

class Fragment2Ass10 : Observer ,Fragment() {

    private var fragment2: FrameLayout? = null
    private var txtNum : TextView? = null
    private var handler = Handler()
    private var num = 0

    override fun update(number: Int) {
        num = number
        if(num < 0){
            txtNum?.setText(" ")
            fragment2!!.setBackgroundColor(Color.WHITE);
        }else
        {
            runnable.run()
        }
    }

    override fun stop() {
        handler.removeCallbacks(runnable)
        txtNum?.setText(" ")
        fragment2!!.setBackgroundColor(Color.WHITE);
    }

    private var runnable = object :Runnable{
        var i = 0
        override fun run() {
            if(i <= num && i%2 ==0) {
                txtNum?.setText("$i")
                fragment2!!.setBackgroundColor(Color.parseColor("#EE3434")) // đỏ
            }else if(i > num){
                txtNum?.setText(" ")
                fragment2!!.setBackgroundColor(Color.WHITE);
            }
            i++
            handler.postDelayed(this,1000)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fragment2_ass10, container, false)
        fragment2 = view.findViewById(R.id.fragment2Ass10)
        txtNum = view.findViewById(R.id.txtfragment2Ass10)

        return view
    }
}