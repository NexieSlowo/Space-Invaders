package com.example.spaceinvaders

import android.graphics.Color

class MissileAlly(missileDistance : Float,missileDebut : Float,missileFin : Float,initialMissileVitesse : Float,width:Float,view: SpaceView) : Missile(missileDistance,missileDebut,missileFin,initialMissileVitesse,width,view) {
    init {
        missilePaint.color = Color.GREEN
    }

    override fun update(interval :Double) {
        var up = (interval * missileVitesse).toFloat()
        missile.offset(0f, -up)
    }
}