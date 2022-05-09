package com.example.spaceinvaders

import android.graphics.Color

class MissileGreen(missileDistance : Float,missileDebut : Float,missileFin:Float,initialMissileVitesse : Float,width : Float,view : SpaceView,/*missile : MissileEnemy*/) : MissileEnemy(missileDistance,missileDebut,missileFin,initialMissileVitesse,width,view) {
    init {
        missilePaint.color = Color.GREEN
    }
    override fun faitQlqCh(enemySpaceship: EnemySpaceship,allySpaceship: AllySpaceship,obstacle: Obstacle,timeee: Timeee){
        enemySpaceship.gainLife()
    }

}