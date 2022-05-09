package com.example.spaceinvaders

import android.graphics.Color

class MissileRed(missileDistance : Float,missileDebut:Float,missileFin:Float,initialMissileVitesse:Float,width:Float,view: SpaceView):MissileEnemy(missileDistance,missileDebut,missileFin,initialMissileVitesse,width,view) {
    init{
        missilePaint.color = Color.RED
    }
    override fun faitQlqCh(enemySpaceship: EnemySpaceship,allySpaceship: AllySpaceship,obstacle: Obstacle,timeee: Timeee){
        allySpaceship.loseLife()

    }

}