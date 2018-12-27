package com.fbatista.kotlincarsselling

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.fbatista.kotlincarsselling.adapter.CarAdapter
import com.fbatista.kotlincarsselling.data.Mock
import com.fbatista.kotlincarsselling.domain.Car
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val carsList = ArrayList<Car>()

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putParcelableArrayList(Car.KEY_CARS, carsList)
        super.onSaveInstanceState(outState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        carsList.addAll(
                savedInstanceState?.getParcelableArrayList(Car.KEY_CARS)
                        ?: Mock().gerarCars(resources))


        initRecyclerView()
    }

    private fun initRecyclerView() {

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val divider = DividerItemDecoration(this, layoutManager.orientation)
        recyclerView.addItemDecoration(divider)

        val adapter = CarAdapter(carsList, this)
        recyclerView.adapter = adapter

        recyclerView.setHasFixedSize(true)


    }
}
