package com.fbatista.kotlincarsselling.data

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.fbatista.kotlincarsselling.R
import com.fbatista.kotlincarsselling.domain.Acessory
import com.fbatista.kotlincarsselling.domain.Brand
import com.fbatista.kotlincarsselling.domain.Car
import com.fbatista.kotlincarsselling.domain.Engine

import java.util.*
import kotlin.collections.ArrayList


class Mock {
    private fun gerarMotor() : Engine {
        val modelos = arrayOf("V-Tec", "Rocan", "Zar-T")
        val cilindros = arrayOf(4, 4, 8)
        val Brands = arrayOf("Volkswagen", "Ford", "GM")
        val randIndex = Random().nextInt(3)

        return Engine( modelos[randIndex], cilindros[randIndex], Brands[randIndex])
    }

    private fun gerarAcessory() : Acessory {
        val nomes = arrayOf("Teto solar", "Multimídia", "Aro 21 (Sport)", "Bancos de couro")
        val precos = arrayOf(2500f, 5600f, 8000f, 980f)
        val randIndex = Random().nextInt(4)

        return Acessory( nomes[randIndex], precos[randIndex] )
    }

    private fun gerarListaAcessorys() : List<Acessory> {
        val acessories = LinkedList<Acessory>()
        val randIndex = Random().nextInt(3) + 1

        while( acessories.size < randIndex ){
            val aux = gerarAcessory()

            if( aux !in acessories ){
                acessories.add( aux )
            }
        }


        return acessories
    }

    private fun gerarBitmap( resources: Resources, imagemRes: Int ) : Bitmap {
        return BitmapFactory.decodeResource( resources, imagemRes )
    }

    fun gerarCars(resources: Resources ) : List<Car> {

        val Cars = listOf(
                Car(
                        "Impala",
                        2014,
                        Brand("Chevrolet", R.drawable.chevrolet_logo),
                        gerarMotor(),
                        89_997f,
                        gerarListaAcessorys(),
                        gerarBitmap(resources, R.drawable.chevrolet_impala) ),
                Car(
                        "Evoque",
                        2017,
                        Brand("Land Rover", R.drawable.land_rover_logo),
                        gerarMotor(),
                        228_500f,
                        gerarListaAcessorys(),
                        gerarBitmap(resources, R.drawable.land_rover_evoque) ),
                Car(
                        "Toureg",
                        2017,
                        Brand("Volkswagen", R.drawable.volkswagen_logo),
                        gerarMotor(),
                        327_793f,
                        gerarListaAcessorys(),
                        gerarBitmap(resources, R.drawable.volkswagen_toureg) ),
                Car(
                        "Fusion",
                        2017,
                        Brand("Ford", R.drawable.ford_logo),
                        gerarMotor(),
                        98_650f,
                        gerarListaAcessorys(),
                        gerarBitmap(resources, R.drawable.ford_fusion) ),
                Car(
                        "Taurus",
                        2015,
                        Brand("Ford", R.drawable.ford_logo),
                        gerarMotor(),
                        113_985f,
                        gerarListaAcessorys(),
                        gerarBitmap(resources, R.drawable.ford_taurus) )
        )

        return Cars
    }
}