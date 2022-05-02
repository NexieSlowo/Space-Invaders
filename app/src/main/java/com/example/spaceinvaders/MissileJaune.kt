package com.example.spaceinvaders

import android.graphics.Color

class MissileJaune(missileDistance : Float,missileDebut : Float,missileFin : Float,initialMissileVitesse : Float,width:Float,view: SpaceView) : MissileEnemy(missileDistance,missileDebut,missileFin,initialMissileVitesse,width,view), InterfaceAddTime {
    override fun addtime() {
        TODO("Not yet implemented")
    }
    init {
        missilePaint.color = Color.YELLOW
    }
}