package com.example.spaceinvaders

import android.graphics.Canvas
import android.graphics.Color
import android.widget.ImageView
import android.widget.Toast

class MissileAlly(
    missileDistance       : Float ,
    missileDebut          : Float ,
    missileFin            : Float ,
    initialMissileVitesse : Float ,
    width                 : Float ,
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

    override fun reset(){
        missileOnScreen = false
    }
    override fun deplacementMissile(interval: Double){
        val up = (interval * missileVitesse).toFloat()
        missile.offset(0f, -up)
    }


    override fun update(interval :Double,enemySpaceship: EnemySpaceship,allySpaceship: AllySpaceship,bonus: Bonus,timeee: Timeee) {
        if(missileOnScreen){
            //var missile_touche_vaisseau: Boolean = (missile.top< enemySpaceship.SpaceshipDebut && missile.left > enemySpaceship.SpaceshipDistance && missile.right < enemySpaceship.SpaceshipDistance + enemySpaceship.width)
            //var missile_touche_bonus: Boolean = (missile.top< bonus.Debut && missile.left > bonus.Distance && missile.right < bonus.Distance + bonus.width)

            deplacementMissile(interval)

            if(missile.intersect(enemySpaceship.SpaceshipDistance,enemySpaceship.SpaceshipDebut,enemySpaceship.SpaceshipDistance+enemySpaceship.width,enemySpaceship.SpaceshipFin)){
                missileDisparait()
                ennemiPerdVie(enemySpaceship)
            }

            if(bonus.OnScreen){
                if(missile.intersect(bonus.Distance,bonus.Debut,bonus.Distance+bonus.width,bonus.Fin)){
                    rajouteTemps(timeee)
                    missileDisparait()
                }

            }
            if(enemySpaceship.vie == 0){
                view.gameOver()
            }

        }
    }


    fun ennemiPerdVie(enemySpaceship: EnemySpaceship){
        enemySpaceship.vie--
    }
    fun rajouteTemps(timeee: Timeee){
        timeee.timeLeft +=5.0
    }

}




