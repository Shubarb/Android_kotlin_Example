package com.example.AndroidAssignment.Assignment10

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.kotlinassignment.R

class Fragment5Ass10 : Observer ,Fragment() {

    private var fragment5: FrameLayout? = null
    private var txtNum : TextView? = null
    private var handler = Handler()
    private var num = 0
    override fun update(number: Int) {
        num = number
        if(num < 0){
            txtNum?.setText(" ")
            fragment5!!.setBackgroundColor(Color.WHITE)
        }
        else
        {
            runnable.run()
        }
    }

    override fun stop() {
        handler.removeCallbacks(runnable)
        txtNum?.setText(" ")
        fragment5!!.setBackgroundColor(Color.WHITE);
    }

    private var runnable = object :Runnable {
        var i = 2
        override fun run() {
            if(i<=num) {
                if (sont(i) == true) {
                    if (i % 2 == 1) {
                        txtNum?.setText("$i")
                        fragment5!!.setBackgroundColor(Color.parseColor("#41ED34")) //xanh
                    } else if (i % 2 == 0) {
                        txtNum?.setText("$i")
                        fragment5!!.setBackgroundColor(Color.parseColor("#EE3434")) // đỏ
                    }
                }
            }else{
                txtNum?.setText(" ")
                fragment5!!.setBackgroundColor(Color.WHITE);
            }
            i++
            handler.postDelayed(this, 1000)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fragment5_ass10, container, false)
        fragment5 = view.findViewById(R.id.fragment5Ass10)
        txtNum = view.findViewById(R.id.txtfragment5Ass10)

        return view
    }

    fun sont(int:Int): Boolean{
        var flag = true
        for (i in 2..int/ 2) {
            var temp = int % i
            if (temp == 0) {
                flag = false
                break
            }
        }
        return flag
    }

}