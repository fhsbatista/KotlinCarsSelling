package com.fbatista.kotlincarsselling.domain

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable
import com.fbatista.kotlincarsselling.getFormattedPrice
import java.lang.StringBuilder

class Car(
        val model: String,
        val year: Int,
        val brand: Brand,
        val engine: Engine,
        val price: Float,
        val acessories: List<Acessory>,
        val image: Bitmap) : Parcelable {
    fun getAcessoriesFormatted(): String {
        val acessoriesFormatted = StringBuilder()

        for (acessory in acessories) {
            acessoriesFormatted.append("${acessory.name} (${acessory.price.getFormattedPrice()})")
        }

        return acessoriesFormatted.trimEnd().trimEnd(',').toString()
    }

    constructor(source: Parcel) : this(
            source.readString(),
            source.readInt(),
            source.readParcelable<Brand>(Brand::class.java.classLoader),
            source.readParcelable<Engine>(Engine::class.java.classLoader),
            source.readFloat(),
            source.createTypedArrayList(Acessory.CREATOR),
            source.readParcelable<Bitmap>(Bitmap::class.java.classLoader)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(model)
        writeInt(year)
        writeParcelable(brand, 0)
        writeParcelable(engine, 0)
        writeFloat(price)
        writeTypedList(acessories)
        writeParcelable(image, 0)
    }

    companion object {
        @JvmField
        val KEY_CARS = "cars"

        @JvmField
        val CREATOR: Parcelable.Creator<Car> = object : Parcelable.Creator<Car> {
            override fun createFromParcel(source: Parcel): Car = Car(source)
            override fun newArray(size: Int): Array<Car?> = arrayOfNulls(size)
        }
    }


}