package com.example.AndroidAssignment.Assignment6.Bai1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.example.kotlinassignment.R

class DialogActivityMain : AppCompatActivity(),SendDialog {

    private lateinit var mfragmentManager : FragmentManager
    private var txtshow: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_main)

        mfragmentManager = supportFragmentManager
        var btnshowdialog =findViewById<Button>(R.id.btnshowdialog)
        btnshowdialog.setOnClickListener {
            val dialogFragment = FragmentDialog(this)

            // using onCreateView
            val fragmentTransaction = mfragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.framelayout1,dialogFragment,"dialog")
            fragmentTransaction.commit()

            // using onCreateDialog
//            dialogFragment.show(mfragmentManager, null)
        }
    }
    override fun sendDialog1(msg: String) {
        txtshow = findViewById(R.id.txtConfirm)
        txtshow?.setText(msg)
        val dialogFragment = FragmentDialog(this)
        val fragmentTransaction = mfragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout1,dialogFragment,"dialog")
        fragmentTransaction.remove(dialogFragment).commit()

    }
}

