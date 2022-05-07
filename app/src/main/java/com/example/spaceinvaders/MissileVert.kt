package com.example.spaceinvaders

import android.graphics.Color

class MissileVert(missileDistance : Float,missileDebut : Float,missileFin:Float,initialMissileVitesse : Float,width : Float,view : SpaceView,/*missile : MissileEnemy*/) : MissileEnemy(missileDistance,missileDebut,missileFin,initialMissileVitesse,width,view), InterfaceAddTime {
    init {
        missilePaint.color = Color.GREEN
    }
    override fun faitQlqCh(enemySpaceship: EnemySpaceship,allySpaceship: AllySpaceship,bonus: Bonus,timeee: Timeee){
        enemySpaceship.gagneVie()
    }

}