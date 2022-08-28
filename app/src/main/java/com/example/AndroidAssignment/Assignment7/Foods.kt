package com.example.AndroidAssignment.Assignment7


import android.os.Parcel
import android.os.Parcelable

class Foods(var imgId: Int, var name:String,var code:Int, var discription: String, var cost: Float): Parcelable{
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

    companion object CREATOR : Parcelable.Creator<Foods> {
        override fun createFromParcel(parcel: Parcel): Foods {
            return Foods(parcel)
        }

        override fun newArray(size: Int): Array<Foods?> {
            return arrayOfNulls(size)
        }
    }


}