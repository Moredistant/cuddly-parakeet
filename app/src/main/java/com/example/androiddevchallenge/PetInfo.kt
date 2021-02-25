package com.example.androiddevchallenge

import android.os.Parcel
import android.os.Parcelable

data class PetInfo(
    val name: String,
    val variety: String,
    val age: String,
    val address: String,
    val requirements: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(variety)
        parcel.writeString(age)
        parcel.writeString(address)
        parcel.writeString(requirements)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PetInfo> {
        override fun createFromParcel(parcel: Parcel): PetInfo {
            return PetInfo(parcel)
        }

        override fun newArray(size: Int): Array<PetInfo?> {
            return arrayOfNulls(size)
        }
    }
}
