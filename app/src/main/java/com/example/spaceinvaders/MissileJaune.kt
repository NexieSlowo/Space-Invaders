package com.example.spaceinvaders

import android.graphics.Color

class MissileJaune(missileDistance : Float,missileDebut : Float,missileFin : Float,initialMissileVitesse : Float,width:Float,view: SpaceView) : MissileEnemy(missileDistance,missileDebut,missileFin,initialMissileVitesse,width,view) {
    init {
        missilePaint.color = Color.YELLOW
    }
}