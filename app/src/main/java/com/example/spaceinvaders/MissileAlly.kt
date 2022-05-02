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


    override fun deplacement_du_missile(interval: Double){
        val up = (interval * missileVitesse).toFloat()
        missile.offset(0f, -up)
    }


    override fun update(interval :Double,enemySpaceship: EnemySpaceship,allySpaceship: AllySpaceship) {
        deplacement_du_missile(interval)

        var missile_touche_vaisseau: Boolean = (missile.top< enemySpaceship.SpaceshipDebut && missile.left > enemySpaceship.SpaceshipDistance && missile.right < enemySpaceship.SpaceshipDistance + enemySpaceship.width)
        if(missile_touche_vaisseau){
            missile_disparait()
            ennemi_perd_vie(enemySpaceship)
        }
    }


    fun ennemi_perd_vie(enemySpaceship: EnemySpaceship){
        enemySpaceship.vie =2
    }


}




