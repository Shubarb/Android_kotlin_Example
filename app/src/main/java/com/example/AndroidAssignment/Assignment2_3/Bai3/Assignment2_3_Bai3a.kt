package com.example.AndroidAssignment.Assignment2_3.Bai3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.AndroidAssignment.Assignment2_3.Bai2.Assignment2_3_Bai2b
import com.example.kotlinassignment.R

class Assignment2_3_Bai3a : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assignment23_bai3a)

        val url = "https://www.youtube.com/channel/UCQu-MUJnuT9Iz44B3VvtgZg"

        var share = findViewById<Button>(R.id.btnshare)
        share.setOnClickListener{
            val intent = Intent ()
            intent.action = Intent.ACTION_SEND
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, url)
            var chooser = Intent.createChooser(intent,"Share using ... ")
            startActivity(chooser)
        }
    }
}