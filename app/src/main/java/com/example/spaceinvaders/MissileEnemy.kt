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

    override fun updatePosition(interval: Double){
        var up = (interval * missileSpeed).toFloat()
        missile.offset(0f, up)
    }


    override fun update(interval :Double,enemySpaceship: EnemySpaceship,allySpaceship:AllySpaceship,bonus: Bonus,timeee: Timeee) {
        if(missileOnScreen){
            updatePosition(interval)
            //var missile_touche_vaisseau = (missile.bottom> allySpaceship.SpaceshipTop && missile.left > allySpaceship.SpaceshipLeft && missile.right < allySpaceship.SpaceshipLeft + allySpaceship.width)
            if(missile.intersect(allySpaceship.SpaceshipLeft,allySpaceship.SpaceshipTop,allySpaceship.SpaceshipLeft+allySpaceship.width, allySpaceship.SpaceshipBottom)){
                //missileDisparait()
                faitQlqCh(enemySpaceship,allySpaceship,bonus,timeee)
                reset()
            }
            if(bonus.OnScreen) {
                if (missile.intersect(
                        bonus.Distance,
                        bonus.Top,
                        bonus.Distance + bonus.width,
                        bonus.Bottom
                    )
                ) {reset()}
            }
        }
    }



    abstract fun faitQlqCh(enemySpaceship: EnemySpaceship,allySpaceship: AllySpaceship,bonus: Bonus,timeee: Timeee)


}