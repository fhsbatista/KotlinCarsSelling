package com.fbatista.kotlincarsselling.domain

import android.os.Parcel
import android.os.Parcelable

data class Acessory(
        val name: String,
        val price: Float
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readFloat()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
        writeFloat(price)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Acessory> = object : Parcelable.Creator<Acessory> {
            override fun createFromParcel(source: Parcel): Acessory = Acessory(source)
            override fun newArray(size: Int): Array<Acessory?> = arrayOfNulls(size)
        }
    }
}
