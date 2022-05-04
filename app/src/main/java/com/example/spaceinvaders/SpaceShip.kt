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

    open val spaceship= RectF(
        SpaceshipDistance, SpaceshipDebut,
        SpaceshipDistance + width, SpaceshipFin
    )
    //val spaceshipPaint = Paint()
    var spaceshipVitesse= initialSpaceshipVitesse
    val spaceshipPaint = Paint()
    init{spaceshipPaint.color = Color.WHITE}



     abstract fun setRect()

     abstract fun draw(canvas:Canvas)

     abstract fun update(interval: Double)

     abstract fun deplacement_du_vaisseau(up: Float)

    /* abstract fun reset()*/






}
