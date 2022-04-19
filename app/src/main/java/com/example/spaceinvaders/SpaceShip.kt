package com.example.spaceinvaders



import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF

class SpaceShip(var SpaceshipDistance: Float, var SpaceshipDebut: Float, var SpaceshipFin: Float, var initialSpaceshipVitesse: Float, var width: Float, var view: SpaceView) {

    val spaceship= RectF(SpaceshipDistance, SpaceshipDebut,
        SpaceshipDistance + width, SpaceshipFin)
    val spaceshipPaint = Paint()
    var spaceshipVitesse= initialSpaceshipVitesse

    fun setRect() {
        spaceship.set(SpaceshipDistance, SpaceshipDebut,
            SpaceshipDistance + width, SpaceshipFin)
        spaceshipVitesse= initialSpaceshipVitesse
    }


    fun draw(canvas: Canvas) {
        spaceshipPaint.color = Color.RED
        canvas.drawRect(spaceship, spaceshipPaint)
    }

    fun update(interval: Double) {
        var up = (interval * spaceshipVitesse).toFloat()
        spaceship.offset(up, 0f)
        if (spaceship.left < 0 || spaceship.right > view.screenWidth) {
            spaceshipVitesse *= -1
            up = (interval * 3 * spaceshipVitesse).toFloat()
            spaceship.offset(up, 0f)
        }
    }
}
