package com.example.AndroidAssignment.Assignment9

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.AndroidAssignment.Assignment8.FragmentListMusic
import com.example.AndroidAssignment.Assignment8.ListMusicAdapter
import com.example.AndroidAssignment.Assignment8.Music
import com.example.kotlinassignment.R
//import java.util.jar.Manifest
import android.Manifest
import android.content.Intent
import android.provider.MediaStore
import android.widget.Toast

class MainActivityPhonebook : AppCompatActivity() {
    private var btnDanhBa : ImageView? = null
    private var btnAdd: ImageView? = null
    private lateinit var mfragmentManager : FragmentManager
    val listnumber: MutableList<Contact> = ArrayList()

    private val mPermissionList =
        arrayOf(Manifest.permission.READ_CONTACTS)
    private  fun checkPermission(permission: String?): Boolean{
        return ContextCompat.checkSelfPermission(this,permission!!) == PackageManager.PERMISSION_GRANTED
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_phonebook)
        btnDanhBa = findViewById(R.id.imgDanhBa)
        btnAdd = findViewById(R.id.imgAdd)
        mfragmentManager = supportFragmentManager

        val adapterRecycle = ListNumberAdapter(listnumber,this)
        val linearLayoutManager = LinearLayoutManager(this)
        val rcv = findViewById<RecyclerView>(R.id.rcvnumber)

        rcv.adapter = adapterRecycle
        rcv.layoutManager = linearLayoutManager

        if(!checkPermission(Manifest.permission.READ_CONTACTS)){
            this.requestPermissions(mPermissionList,0)
        }

        btnDanhBa?.setOnClickListener {
            btnDanhBa?.setImageResource(R.drawable.danhba_green)
            Toast.makeText(this,"Danh bạ", Toast.LENGTH_SHORT).show()
            val contacts = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null)
            while(contacts!!.moveToNext()){
                val name = contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                val number = contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                listnumber.add(Contact(name,number))
            }
            contacts.close()
        }

        btnAdd?.setOnClickListener {
            var intent = Intent(this, AddNewActivity::class.java)
            startActivityForResult(intent,0)
        }


    }
}