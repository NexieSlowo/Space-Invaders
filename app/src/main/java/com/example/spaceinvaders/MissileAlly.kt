package com.example.spaceinvaders

import android.graphics.Canvas
import android.graphics.Color
import android.widget.ImageView
import android.widget.Toast

class MissileAlly(
    MissileLeft       : Float ,
    missileTop          : Float ,
    missileBottom            : Float ,
    initialMissileSpeed : Float ,
    width                 : Float ,
    view                  : SpaceView):

    Missile(
        MissileLeft,
        missileTop,
        missileBottom,
        initialMissileSpeed,
        width,
        view){

    init {
        missilePaint.color = Color.RED
    }




    override fun updatePosition(interval :Double,enemySpaceship: EnemySpaceship,allySpaceship: AllySpaceship,obstacle: Obstacle,timeee: Timeee) {
        if(missileOnScreen){
            //var missile_touche_vaisseau: Boolean = (missile.top< enemySpaceship.SpaceshipTop && missile.left > enemySpaceship.SpaceshipLeft && missile.right < enemySpaceship.SpaceshipLeft + enemySpaceship.width)
            //var missile_touche_bonus: Boolean = (missile.top< bonus.Debut && missile.left > bonus.Distance && missile.right < bonus.Distance + bonus.width)

            val up = (interval * missileSpeed).toFloat()
            missile.offset(0f, -up)

            if(missile.intersect(enemySpaceship.SpaceshipLeft,enemySpaceship.SpaceshipTop,enemySpaceship.SpaceshipLeft+enemySpaceship.width,enemySpaceship.SpaceshipBottom)){
                reset()
                enemySpaceship.loseLife()
            }

            if(obstacle.OnScreen){
                if(missile.intersect(obstacle.Left,obstacle.Top,obstacle.Left+obstacle.width,obstacle.Bottom)){

                    reset()
                }
            }


        }
    }




}




