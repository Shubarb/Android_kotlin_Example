package com.example.AndroidAssignment.Assignment5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.example.AndroidAssignment.Assignment4.Bai2.ListView.Food
import com.example.AndroidAssignment.Assignment4.Bai2.RecycleView.FoodDetailsRecycleView
import com.example.kotlinassignment.R

class ActivityBackground : AppCompatActivity(),SendRcvToDetail {

    private lateinit var mfragmentManager : FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_background)

        val rcvFoodFragment = RcvFoodFragment(this)


        val  putInformationFragment = PutInfoFragment(this)

//        val foodDetailRcv = DetailsFragment(this)

        mfragmentManager = supportFragmentManager

        val fragmentTransaction = mfragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.flRecyclerview,rcvFoodFragment,"rcv")
        fragmentTransaction.add(R.id.flPutInformation,putInformationFragment,"put")
//        fragmentTransaction.add(R.id.flFoodDetail,foodDetailRcv,"detail")
        fragmentTransaction.commit()
    }

    override fun sendPutToRcv(
        code: Int?,
        cost: Float?,
        name: String?,
        infor: String?
    ) {
        val put = mfragmentManager.findFragmentByTag("rcv") as RcvFoodFragment
        put.setDataPut(code,cost,name,infor)
    }

    override fun senRcvToDetail(msg: Food?) {
        var fragmentProductDetail = DetailsFragment(this)
        mfragmentManager = supportFragmentManager

        val bundle = Bundle()
        bundle.putInt("code",msg!!.code)
        bundle.putFloat("cost",msg!!.cost)
        bundle.putString("name",msg?.name)
        bundle.putString("info",msg?.discription)
        bundle.putInt("img",msg!!.imgId)
        fragmentProductDetail.arguments = bundle

        val fragmentTransaction = mfragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.flPutInformation, fragmentProductDetail)
        fragmentTransaction.commit()
    }
    override fun senDetailToPut(
        code: Int?,
        cost: Float?,
        name: String?,
        infor: String?
    ) {
        val fragmentProductInput = PutInfoFragment(this)
        mfragmentManager = supportFragmentManager

        val bundle = Bundle()
        bundle.putInt("code",code!!)
        bundle.putFloat("cost",cost!!)
        bundle.putString("name",name)
        bundle.putString("info",infor)
        fragmentProductInput.arguments = bundle

        val fragmentTransaction = mfragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.flPutInformation, fragmentProductInput)
        fragmentTransaction.commit()
    }

}