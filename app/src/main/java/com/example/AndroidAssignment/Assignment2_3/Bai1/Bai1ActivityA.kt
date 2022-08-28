package com.example.AndroidAssignment.Assignment2_3.Bai1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.example.kotlinassignment.R

class Bai1ActivityA : AppCompatActivity() {

    var data: String = "Hello!" +" , "+ "Salut!"+" , " +"Hallo!"+ " , "+ "Ciao!"+ " , "+"Ahoj!"+
            " , "+"YAHsahs!"+ " , "+"Bog!"+ " , "+"Hej ! "+" Czesc!"+ " , "+" Czesc!"+
            " , "+" Kon'nichiwa! "+" , "+" Annyeonghaseyo!"+ " , "+" Ní! "+ " , "+"Shalom!"+" , "+"Sah-wahd-dee-kah! "+
            " , "+" Merhaba!"+ " , "+" Hujambo! "+ " , "+" Olá! "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bai1_activity_a)

        val intent: Intent = Intent (this, Bai1ActivityB::class.java)
        intent.putExtra("list",data)
        Log.d("aaa",data)
        startActivity(intent)

    }
}