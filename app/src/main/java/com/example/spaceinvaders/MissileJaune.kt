package com.example.spaceinvaders

import android.graphics.Color

class MissileJaune(missileDistance : Float,missileDebut : Float,missileFin : Float,initialMissileVitesse : Float,width:Float,view: SpaceView) : MissileEnemy(missileDistance,missileDebut,missileFin,initialMissileVitesse,width,view){

    init {
        missilePaint.color = Color.YELLOW
    }

    /*override fun faitQlqCh(
        enemySpaceship: EnemySpaceship,
        allySpaceship: AllySpaceship,
        bonus: Bonus,
        timeee: Timeee
    ) {
        TODO("Not yet implemented")
    }*/

    override fun faitQlqCh(enemySpaceship: EnemySpaceship,allySpaceship: AllySpaceship,bonus: Bonus,timeee: Timeee){
        timeee.enleveTemps()
    }


    //override fun changetime() {

       // view.timeLeft -= -10.0
    //}
}