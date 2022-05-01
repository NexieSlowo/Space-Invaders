package com.example.spaceinvaders



import android.content.Context
import android.content.res.Resources
import android.graphics.*

abstract class SpaceShip(
    var vie: Int,
    var SpaceshipDistance: Float,
    var SpaceshipDebut: Float,
    var SpaceshipFin: Float,
    var initialSpaceshipVitesse: Float,
    var width: Float,
    var view: SpaceView,
    context: SpaceView,


    ) {

    open val spaceship= Rect(
        SpaceshipDistance.toInt(), SpaceshipDebut.toInt(),
        (SpaceshipDistance + width).toInt(), SpaceshipFin.toInt()
    )
    //val spaceshipPaint = Paint()
    var spaceshipVitesse= initialSpaceshipVitesse





     abstract fun setRect()

     abstract fun draw(canvas:Canvas)


     abstract fun update(interval: Double)



    /* abstract fun reset()*/






}
