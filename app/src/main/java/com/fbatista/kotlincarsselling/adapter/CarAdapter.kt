package com.fbatista.kotlincarsselling.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.fbatista.kotlincarsselling.R
import com.fbatista.kotlincarsselling.bold
import com.fbatista.kotlincarsselling.domain.Car
import com.fbatista.kotlincarsselling.getFormattedPrice

class CarAdapter(val carsList: List<Car>, val context: Context) : RecyclerView.Adapter<CarAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarAdapter.MyViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_car, parent, false)

        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return carsList.size
    }

    override fun onBindViewHolder(holder: CarAdapter.MyViewHolder, position: Int) {

        holder.setData(carsList[position])
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivImage: ImageView
        val ivLogo: ImageView
        val tvModel: TextView
        val tvBrand: TextView
        val tvEngine: TextView
        val tvAcessories: TextView
        val tvPrice: TextView

        init {
            ivImage = itemView.findViewById(R.id.iv_image)
            ivLogo = itemView.findViewById(R.id.iv_logo)
            tvModel = itemView.findViewById(R.id.tv_model)
            tvBrand = itemView.findViewById(R.id.tv_brand)
            tvEngine = itemView.findViewById(R.id.tv_engine)
            tvAcessories = itemView.findViewById(R.id.tv_acessories)
            tvPrice = itemView.findViewById(R.id.tv_price)
        }

        fun setData(car: Car) {
            ivImage.setImageBitmap(car.image)
            tvModel.text = car.model
            ivLogo.setImageResource(car.brand.logo)
            tvBrand.text = String.format("%s - %d", car.brand.name, car.year)
            tvEngine.text = "Motor: ".bold().append("${car.engine.model} ${car.engine.cylinders} - ${car.engine.brand}")
            tvAcessories.text = "Acessórios: ".bold().append("${car.getAcessoriesFormatted()}")

            tvPrice.text = car.price.getFormattedPrice()
        }
    }
}