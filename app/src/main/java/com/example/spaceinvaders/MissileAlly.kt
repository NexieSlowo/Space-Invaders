package com.example.spaceinvaders

import android.graphics.Canvas
import android.graphics.Color
import android.widget.ImageView
import android.widget.Toast

class MissileAlly(
    missileDistance       : Float,
    missileDebut          : Float,
    missileFin            : Float,
    initialMissileVitesse : Float,
    width                 : Float,
    view                  : SpaceView):

    Missile(
        missileDistance,
        missileDebut,
        missileFin,
        initialMissileVitesse,
        width,
        view){

    init {
        missilePaint.color = Color.GREEN
    }


    override fun deplacementMissile(interval: Double){
        val up = (interval * missileVitesse).toFloat()
        missile.offset(0f, -up)
    }


    override fun update(interval :Double,enemySpaceship: EnemySpaceship,allySpaceship: AllySpaceship) {
        if(missileOnScreen){
            deplacementMissile(interval)
            if(missile.intersect(enemySpaceship.SpaceshipDistance,enemySpaceship.SpaceshipDebut,enemySpaceship.SpaceshipDistance+enemySpaceship.width,enemySpaceship.SpaceshipFin)/*missile.top< enemySpaceship.SpaceshipDebut && missile.left > enemySpaceship.SpaceshipDistance && missile.right < enemySpaceship.SpaceshipDistance + enemySpaceship.width*/){
                missileDisparait()
                ennemiPerdVie(enemySpaceship)
            }
        }
    }


    fun ennemiPerdVie(enemySpaceship: EnemySpaceship){
        enemySpaceship.vie -=1
    }


}




