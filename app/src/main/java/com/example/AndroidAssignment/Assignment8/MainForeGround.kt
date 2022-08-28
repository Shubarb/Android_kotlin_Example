package com.example.AndroidAssignment.Assignment8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.AndroidAssignment.Assignment4.Bai2.ListView.Food
import com.example.AndroidAssignment.Assignment5.DetailsFragment
import com.example.kotlinassignment.R

class MainForeGround : AppCompatActivity(),Click {

    private lateinit var mfragmentManager : FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fore_ground)

        mfragmentManager = supportFragmentManager


        val listMusicFragment = FragmentListMusic(this)

        val fragmentTransaction = mfragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.framelist,listMusicFragment)
        fragmentTransaction.commit()
    }

    override fun click(msg: Music?) {
        var playMusicFragment = PlayMusicFragment(this)
        mfragmentManager = supportFragmentManager

        val bundle = Bundle()
        bundle.putString("time",msg!!.time)
        bundle.putInt("times",msg!!.times)
        bundle.putBoolean("flag",msg!!.flag)
        playMusicFragment.arguments = bundle
        ForeGroundService.startService(this,"${msg!!.nameMusic}", "${msg!!.singer}", msg!!.times,msg!!.music)
        val fragmentTransaction = mfragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.framemusic, playMusicFragment)
        fragmentTransaction.commit()
    }

    override fun pauses(flag: Boolean,p:String) {
        ForeGroundService.pause(this,p,flag)
    }

    override fun close() {
        ForeGroundService.stop(this)
    }

    override fun nexts() {
        ForeGroundService.nexts(this,"Next")
    }

    override fun prevs() {
        ForeGroundService.prevs(this,"Previous")
    }


}