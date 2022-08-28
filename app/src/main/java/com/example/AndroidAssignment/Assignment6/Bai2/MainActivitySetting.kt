package com.example.AndroidAssignment.Assignment6.Bai2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.preference.PreferenceManager
import com.example.kotlinassignment.R

class MainActivitySetting : AppCompatActivity() {

    private var txtCheckBox: TextView? = null
    private var txtedit : TextView? = null
    private var txtlist: TextView? = null
    private var txtswitch: TextView? = null
    private var txtmulti: TextView? = null
    private var txtseek: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_setting)
        txtCheckBox = findViewById(R.id.txtcheckbox)
        txtedit = findViewById(R.id.txtedit)
        txtlist = findViewById(R.id.txtlist)
        txtswitch = findViewById(R.id.txtswitch)
        txtmulti = findViewById(R.id.txtmulti)
        txtseek = findViewById(R.id.txtseek)
        val btn = findViewById<Button>(R.id.btnSetting)
        btn.setOnClickListener {
            var intent = Intent(this, SettingsActivity::class.java)
            startActivityForResult(intent,1)
        }
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val checkBox = prefs.getBoolean("check_box",false)
        txtCheckBox?.setText("CheckBox: ${checkBox}")
        val txtValue = prefs.getString("edit_text", "<unser>")
        txtedit?.setText("EditText: ${txtValue} ")
        val list = prefs.getString("list","<unser>")
        txtlist?.setText("List: ${list}")
        val switch = prefs.getBoolean("switch", false)
        txtswitch?.setText("Switch: ${switch}")
        val multi = prefs.getStringSet("multiSelectList",null)
        txtmulti?.setText("MultiSelectList: ${multi}")
        val seek = prefs.getInt("seek",0)
        txtseek?.setText("Seekbar: ${seek}%")

    }

    override fun onRestart() {
        super.onRestart()
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val checkBox = prefs.getBoolean("check_box",false)
        txtCheckBox?.setText("CheckBox: ${checkBox}")
        val txtValue = prefs.getString("edit_text", "<unser>")
        txtedit?.setText("EditText: ${txtValue} ")
        val list = prefs.getString("list","<unser>")
        txtlist?.setText("List: ${list}")
        val switch = prefs.getBoolean("switch", false)
        txtswitch?.setText("Switch: ${switch}")
        val multi = prefs.getStringSet("multiSelectList",null)
        txtmulti?.setText("MultiSelectList: ${multi}")
        val seek = prefs.getInt("seek",0)
        txtseek?.setText("Seekbar: ${seek}%")
    }

}