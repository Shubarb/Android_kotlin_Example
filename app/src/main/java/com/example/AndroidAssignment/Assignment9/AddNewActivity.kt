package com.example.AndroidAssignment.Assignment9

import android.Manifest
import android.app.Activity
import android.content.ContentProviderOperation
import android.content.ContentProviderOperation.newInsert
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.Menu
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.AndroidAssignment.Assignment4.Bai1.ActivityA
import com.example.kotlinassignment.R
import com.example.kotlinassignment.databinding.ActivityMainBinding


class AddNewActivity : AppCompatActivity() {
    private var btnluu : ImageView? = null
    private var btnthoat: ImageView? = null
    private var edtName: EditText? = null
    private var edtNumber: EditText? = null

    private val mPermissionList =
        arrayOf(Manifest.permission.WRITE_CONTACTS)
    private  fun checkPermission(permission: String?): Boolean{
        return ContextCompat.checkSelfPermission(this,permission!!) == PackageManager.PERMISSION_GRANTED
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add_new)

        btnluu = findViewById(R.id.imgLuu)
        btnthoat = findViewById(R.id.imgThoat)
        edtName = findViewById(R.id.edtNamePhone)
        edtNumber = findViewById(R.id.edtNumberPhone)

        val intent = Intent(ContactsContract.Intents.Insert.ACTION)
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE)

        if(!checkPermission(Manifest.permission.WRITE_CONTACTS)){
            this.requestPermissions(mPermissionList,0)
        }

        btnluu?.setOnClickListener {
            Toast.makeText(this, "${edtName?.text}", Toast.LENGTH_SHORT).show()
            intent.putExtra(ContactsContract.Intents.Insert.NAME, edtName?.text.toString())
                .putExtra(ContactsContract.Intents.Insert.PHONE, edtNumber?.text)
                .putExtra(
                    ContactsContract.Intents.Insert.PHONE_TYPE,
                    ContactsContract.CommonDataKinds.Phone.TYPE_WORK
                )
            startActivity(intent)
        }

        btnthoat?.setOnClickListener {
            val intent = Intent (this, MainActivityPhonebook::class.java)
            setResult(RESULT_OK,intent)
            finish()
        }
    }
}
