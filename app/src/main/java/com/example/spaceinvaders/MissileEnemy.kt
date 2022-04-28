package com.example.spaceinvaders
import android.graphics.Color
open class MissileEnemy(missileDistance : Float, missileDebut : Float, missileFin : Float, initialMissileVitesse : Float, width:Float, view: SpaceView) : Missile(missileDistance,missileDebut,missileFin,initialMissileVitesse,width,view) {
   init {
        missilePaint.color = Color.RED
    }

    override fun update(interval :Double) {
        var up = (interval * missileVitesse).toFloat()
        missile.offset(0f, up)
    }
}