package com.example.education

import android.os.Parcel
import android.os.Parcelable

class Spec (var name: String,
            var image: Int,
            var univer: String,
            var faculty: String,
            var test1: String,
            var test2: String,
            var test3: String,
            var score: Int,
            val education: String,
            val qualification: String)  : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(image)
        parcel.writeString(univer)
        parcel.writeString(faculty)
        parcel.writeString(test1)
        parcel.writeString(test2)
        parcel.writeString(test3)
        parcel.writeInt(score)
        parcel.writeString(education)
        parcel.writeString(qualification)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Spec> {
        override fun createFromParcel(parcel: Parcel): Spec {
            return Spec(parcel)
        }

        override fun newArray(size: Int): Array<Spec?> {
            return arrayOfNulls(size)
        }
    }

}

