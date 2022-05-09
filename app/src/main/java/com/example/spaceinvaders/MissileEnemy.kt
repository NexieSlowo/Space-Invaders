package com.example.spaceinvaders
import android.graphics.Canvas
import android.graphics.Color
open abstract class MissileEnemy(
    MissileLeft : Float,
    MissileTop : Float,
    MissileBottom : Float,
    InitialMissileSpeed : Float,
    width:Float, view: SpaceView
):
    Missile(
        MissileLeft,
        MissileTop,
        MissileBottom,
        InitialMissileSpeed,
        width,
        view) {

    init {
        missilePaint.color = Color.GREEN
    }




    override fun updatePosition(interval :Double,enemySpaceship: EnemySpaceship,allySpaceship:AllySpaceship,obstacle: Obstacle,timeee: Timeee) {
        if(missileOnScreen){
            var up = (interval * missileSpeed).toFloat()
            missile.offset(0f, up)
            //var missile_touche_vaisseau = (missile.bottom> allySpaceship.SpaceshipTop && missile.left > allySpaceship.SpaceshipLeft && missile.right < allySpaceship.SpaceshipLeft + allySpaceship.width)
            if(missile.intersect(allySpaceship.SpaceshipLeft,allySpaceship.SpaceshipTop,allySpaceship.SpaceshipLeft+allySpaceship.width, allySpaceship.SpaceshipBottom)){
                //missileDisparait()
                interact(enemySpaceship,allySpaceship,obstacle,timeee)
                reset()
            }
        }
    }



    abstract fun interact(enemySpaceship: EnemySpaceship,allySpaceship: AllySpaceship,obstacle: Obstacle,timeee: Timeee)


}