package com.example.spaceinvaders

import android.graphics.*

class etoile(
    var EtoileDistance: Float,
    var EtoileDebut: Float,
    var EtoileFin: Float,
    var width: Float,
    var view: SpaceView,
    context: SpaceView,


    ) {
    val etoile= Rect(
        EtoileDistance.toInt(), EtoileDebut.toInt(),
        (EtoileDistance + width).toInt(), EtoileFin.toInt()
    )
    //val spaceshipPaint = Paint()
    var image = BitmapFactory.decodeResource(context.resources,R.drawable.star2)



    fun setRect() {
        etoile.set(
            EtoileDistance.toInt(), EtoileDebut.toInt(),
            (EtoileDistance + width).toInt(), (EtoileFin).toInt()
        )
    }


    fun draw(canvas: Canvas) {
        //spaceshipPaint.color = Color.RED
        //canvas.drawRect(spaceship, spaceshipPaint)
        canvas.drawBitmap(image,EtoileDistance,EtoileDebut-view.screenHeight/5,null)

    }


}


