package com.example.AndroidAssignment.Assignment8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.example.kotlinassignment.R
import kotlin.math.max

class PlayMusicFragment(private var click: Click?) : Fragment() {

    private var play: ImageView? = null
    private var prev: ImageView? = null
    private var next: ImageView? = null
    private var seek: SeekBar? = null
    private var maxTime: TextView? = null
    private var time: TextView? = null

    private var timeMusic :Int = 0
    private var timeMaxMusic: String? = null
    private var flag :Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{
            timeMusic = it.getInt("times",0)
            timeMaxMusic = it.getString("time")
            flag = it.getBoolean("flag")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view  = inflater.inflate(R.layout.fragment_play_music, container, false)
        play = view.findViewById(R.id.imgPause)
        prev = view.findViewById(R.id.imgprev)
        next = view.findViewById(R.id.imgnext)
        seek = view.findViewById(R.id.seecBar)
        time = view.findViewById(R.id.timeSeekBar)
        maxTime = view.findViewById(R.id.timeMusic)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        maxTime!!.setText(timeMaxMusic)
        next?.setOnClickListener {
            click?.nexts()
        }

        prev?.setOnClickListener {
            click?.prevs()
        }

        play?.setOnClickListener{
            var PauPl : String = " "
            if(flag == true){
                play?.setImageResource(R.drawable.plays)
                flag = false
                PauPl =  "Pause"
                click?.pauses(flag!!,PauPl)
            }else{
                play?.setImageResource(R.drawable.pauses)
                flag = true
                PauPl =  "Play"
                click?.pauses(flag!!,PauPl)
            }

        }
        seek?.setMax(timeMusic)
        seek?.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener
        {
            override fun onProgressChanged(p0: SeekBar, p1: Int, p2: Boolean)
            {
                if(p2 ) {
                    val p1_minute = (p1 / 60)
                    val p1_second = p1 - p1_minute * 60
                    if(p1_second < 10 && p1_minute < 10){
                        time?.text = "0" + p1_minute.toString() + ":0" + p1_second.toString()
                    }else if(p1_second < 10 && p1_minute >= 10) {
                        time?.text = p1_minute.toString() + ":0" + p1_second.toString()
                    }else if(p1_second >= 10 && p1_minute < 10) {
                        time?.text = "0" + p1_minute.toString() + ":" + p1_second.toString()
                    }else time?.text = p1_minute.toString() + ":" + p1_second.toString()
                }
            }
            override fun onStartTrackingTouch(p0: SeekBar)
            {

            }
            override fun onStopTrackingTouch(p0: SeekBar)
            {

            }
        })


    }

}