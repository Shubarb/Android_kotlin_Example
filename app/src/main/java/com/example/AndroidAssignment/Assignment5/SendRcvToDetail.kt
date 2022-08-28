package com.example.AndroidAssignment.Assignment5

import android.widget.ImageView
import com.example.AndroidAssignment.Assignment4.Bai2.ListView.Food

interface SendRcvToDetail {
    fun sendPutToRcv(code:Int?,cost: Float?,name: String?,infor: String?)
    fun senRcvToDetail(msg: Food?)
    fun senDetailToPut(code:Int?,cost: Float?,name: String?,infor: String? )
}