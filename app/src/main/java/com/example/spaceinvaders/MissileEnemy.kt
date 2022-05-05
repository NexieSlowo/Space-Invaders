package com.example.spaceinvaders
import android.graphics.Canvas
import android.graphics.Color
open class MissileEnemy(
    missileDistance : Float,
    missileDebut : Float,
    missileFin : Float,
    initialMissileVitesse : Float,
    width:Float, view: SpaceView
):
    Missile(
        missileDistance,
        missileDebut,
        missileFin,
        initialMissileVitesse,
        width,
        view) {

    init {
        missilePaint.color = Color.RED
    }

    override fun deplacementMissile(interval: Double){
        var up = (interval * missileVitesse).toFloat()
        missile.offset(0f, up)
    }


    override fun update(interval :Double,enemySpaceship: EnemySpaceship,allySpaceship:AllySpaceship,bonus: Bonus,timeee: Timeee) {
        if(missileOnScreen){
            deplacementMissile(interval)
            //var missile_touche_vaisseau = (missile.bottom> allySpaceship.SpaceshipDebut && missile.left > allySpaceship.SpaceshipDistance && missile.right < allySpaceship.SpaceshipDistance + allySpaceship.width)
            if(missile.intersect(allySpaceship.SpaceshipDistance,view.screenHeight-350f,allySpaceship.SpaceshipDistance+view.screenWidth/4, view.screenHeight-100f)){
                //missileDisparait()
                //joueurPerdVie(allySpaceship)
                missileOnScreen = false
                allySpaceship.vie -=1
            }
        }
    }
    fun joueurPerdVie(allySpaceship: AllySpaceship){
        allySpaceship.vie-=1
    }



}