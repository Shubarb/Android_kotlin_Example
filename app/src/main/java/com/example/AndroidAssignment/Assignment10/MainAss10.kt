package com.example.AndroidAssignment.Assignment10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.example.AndroidAssignment.Assignment5.PutInfoFragment
import com.example.AndroidAssignment.Assignment5.RcvFoodFragment
import com.example.kotlinassignment.R

class MainAss10 : AppCompatActivity(){

    private lateinit var mfragmentManager : FragmentManager
    private var imgAdd: ImageView? = null
    private var imgSub: ImageView? = null
    private var imgPlay: ImageView? = null
    private var imgStop: ImageView? = null
    private var edtMax: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_ass10)

        imgAdd = findViewById(R.id.imgIncrea)
        imgSub = findViewById(R.id.imgDecrea)
        imgPlay = findViewById(R.id.imgPlay)
        imgStop = findViewById(R.id.imgStop)
        edtMax = findViewById(R.id.edtMax)


        val  fragment1Ass10 = Fragment1Ass10()
        val  fragment2Ass10 = Fragment2Ass10()
        val  fragment3Ass10 = Fragment3Ass10()
        val  fragment4Ass10 = Fragment4Ass10()
        val  fragment5Ass10 = Fragment5Ass10()

        mfragmentManager = supportFragmentManager
        val fragmentTransaction = mfragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frame1Ass10,fragment1Ass10,"f1")
        fragmentTransaction.add(R.id.frame2Ass10,fragment2Ass10,"f2")
        fragmentTransaction.add(R.id.frame3Ass10,fragment3Ass10,"f3")
        fragmentTransaction.add(R.id.frame4Ass10,fragment4Ass10,"f4")
        fragmentTransaction.add(R.id.frame5Ass10,fragment5Ass10,"f5")
        fragmentTransaction.commit()

        val number = NumberObserver()

        imgPlay?.setOnClickListener {
            number.registerObserver(fragment1Ass10)
            number.registerObserver(fragment2Ass10)
            number.registerObserver(fragment3Ass10)
            number.registerObserver(fragment4Ass10)
            number.registerObserver(fragment5Ass10)
            number.changeData(edtMax?.text.toString().toInt())
        }

        imgAdd?.setOnClickListener {
            edtMax?.setText("${edtMax?.text.toString().toInt() + 1}")
//            number.changeData(-1)
            number.stop()
            number.unRegisterObserver(fragment1Ass10)
            number.unRegisterObserver(fragment2Ass10)
            number.unRegisterObserver(fragment3Ass10)
            number.unRegisterObserver(fragment4Ass10)
            number.unRegisterObserver(fragment5Ass10)
        }
        imgSub?.setOnClickListener {
            if(edtMax?.text.toString().toInt() != 0) {
                edtMax?.setText("${edtMax?.text.toString().toInt()-1}")
//                number.changeData(-1)
                number.stop()
                number.unRegisterObserver(fragment1Ass10)
                number.unRegisterObserver(fragment2Ass10)
                number.unRegisterObserver(fragment3Ass10)
                number.unRegisterObserver(fragment4Ass10)
                number.unRegisterObserver(fragment5Ass10)
            }else Toast.makeText(this, "Min value = 0",Toast.LENGTH_SHORT).show()
        }

        imgStop?.setOnClickListener {
            number.stop()
            number.unRegisterObserver(fragment1Ass10)
            number.unRegisterObserver(fragment2Ass10)
            number.unRegisterObserver(fragment3Ass10)
            number.unRegisterObserver(fragment4Ass10)
            number.unRegisterObserver(fragment5Ass10)
        }

    }

}