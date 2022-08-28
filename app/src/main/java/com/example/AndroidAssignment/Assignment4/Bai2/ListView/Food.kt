package com.example.AndroidAssignment.Assignment4.Bai2.ListView

import android.os.Parcel
import android.os.Parcelable

class Food(var imgId: Int, var name:String,var code:Int, var discription: String, var cost: Float): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readFloat()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imgId)
        parcel.writeString(name)
        parcel.writeInt(code)
        parcel.writeString(discription)
        parcel.writeFloat(cost)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Food> {
        override fun createFromParcel(parcel: Parcel): Food {
            return Food(parcel)
        }

        override fun newArray(size: Int): Array<Food?> {
            return arrayOfNulls(size)
        }
    }


}