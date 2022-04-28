package com.example.spaceinvaders

import android.graphics.Canvas
import android.graphics.Color

class MissileAlly(missileDistance : Float,missileDebut : Float,missileFin : Float,initialMissileVitesse : Float,width:Float,view: SpaceView) : Missile(missileDistance,missileDebut,missileFin,initialMissileVitesse,width,view) {
    init {
        missilePaint.color = Color.GREEN
    }
    //var allyMissileOnScreen : Boolean = true




    override fun update(interval :Double,enemySpaceship: EnemySpaceship,allySpaceship: AllySpaceship) {

        val up = (interval * missileVitesse).toFloat()
        missile.offset(0f, -up)
        //missileDebut += up

        if(missile.top< enemySpaceship.SpaceshipDebut && missile.left > enemySpaceship.SpaceshipDistance && missile.right < enemySpaceship.SpaceshipDistance + enemySpaceship.width){missileOnScreen = false}
    }


}




