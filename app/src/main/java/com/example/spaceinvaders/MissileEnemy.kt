package com.example.spaceinvaders
import android.graphics.Canvas
import android.graphics.Color
open class MissileEnemy(missileDistance : Float, missileDebut : Float, missileFin : Float, initialMissileVitesse : Float, width:Float, view: SpaceView) : Missile(missileDistance,missileDebut,missileFin,initialMissileVitesse,width,view) {

    init {
        missilePaint.color = Color.RED
    }

    override fun deplacement_du_missile(interval: Double){
        var up = (interval * missileVitesse).toFloat()
        missile.offset(0f, up)
    }


    override fun update(interval :Double,enemySpaceship: EnemySpaceship,allySpaceship:AllySpaceship) {
        deplacement_du_missile(interval)
        if(missile.bottom> allySpaceship.SpaceshipDebut && missile.left > allySpaceship.SpaceshipDistance && missile.right < allySpaceship.SpaceshipDistance + allySpaceship.width){missileOnScreen = false}
    }


}