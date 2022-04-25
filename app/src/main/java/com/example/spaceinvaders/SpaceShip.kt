package com.example.spaceinvaders



import android.content.Context
import android.content.res.Resources
import android.graphics.*

class SpaceShip(
    var SpaceshipDistance: Float,
    var SpaceshipDebut: Float,
    var SpaceshipFin: Float,
    var initialSpaceshipVitesse: Float,
    var width: Float,
    var view: SpaceView,
    context: SpaceView,


    ) {

    val spaceship= Rect(
        SpaceshipDistance.toInt(), SpaceshipDebut.toInt(),
        (SpaceshipDistance + width).toInt(), SpaceshipFin.toInt()
    )
    //val spaceshipPaint = Paint()
    var spaceshipVitesse= initialSpaceshipVitesse
    var image = BitmapFactory.decodeResource(context.resources,R.drawable.player2)



    fun setRect() {
        spaceship.set(
            SpaceshipDistance.toInt(), SpaceshipDebut.toInt(),
            (SpaceshipDistance + width).toInt(), (SpaceshipFin).toInt()
        )
        spaceshipVitesse= initialSpaceshipVitesse
    }


    fun draw(canvas: Canvas) {
        //spaceshipPaint.color = Color.RED
        //canvas.drawRect(spaceship, spaceshipPaint)
        canvas.drawBitmap(image,SpaceshipDistance,SpaceshipDebut-view.screenHeight/5,null)

    }

    fun update(interval: Double) {
        var up = (interval * spaceshipVitesse).toFloat()
        spaceship.offset(up.toInt(), 0)
        if (spaceship.left+view.width/20 < 0 || spaceship.right+ view.width/15.3f > view.screenWidth) {
            spaceshipVitesse *= -1
            up = (interval * 4 * spaceshipVitesse).toFloat()
            spaceship.offset(up.toInt(), 0)
        }
        SpaceshipDistance = SpaceshipDistance + up

    }

}
