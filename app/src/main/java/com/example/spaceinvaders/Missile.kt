package com.example.spaceinvaders
import android.graphics.*

open class Missile(var missileDistance: Float, var missileDebut: Float, var missileFin: Float, var initialMissileVitesse: Float, var width: Float, var view: SpaceView, ) {

    val missile= RectF(missileDistance, missileDebut,
        missileDistance + width, missileFin)


    val missilePaint = Paint()
    var missileVitesse= initialMissileVitesse
    var missileOnScreen = true

    fun setRect() {
        missile.set(missileDistance, missileDebut,
            missileDistance + width, missileFin)
        missileVitesse= initialMissileVitesse

    }


    fun draw(canvas: Canvas) {
        missilePaint.color = Color.BLUE
        canvas.drawRect(missile, missilePaint)

    }

    fun update(interval: Double, enemySpaceship: EnemySpaceship) {
            var up = (interval * missileVitesse).toFloat()
            missile.offset(0f, -up)
        }
    fun update2(interval:Double){
        var up = (interval*missileVitesse).toFloat()
        missile.offset(0f,up)
    }


        /*if (missileDebut>enemySpaceship.enemySpaceshipFin /*&& missileDistance > enemySpaceship.enemySpaceshipDistance && missileDistance +width < enemySpaceship.enemySpaceshipDistance+width*/) {
            missileOnScreen = false}


    }*/

}

