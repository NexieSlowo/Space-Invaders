package com.example.spaceinvaders
import android.graphics.Canvas
import android.graphics.Color
open abstract class MissileEnemy(
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
        missilePaint.color = Color.GREEN
    }

    override fun updatePosition(interval: Double){
        var up = (interval * missileVitesse).toFloat()
        missile.offset(0f, up)
    }


    override fun update(interval :Double,enemySpaceship: EnemySpaceship,allySpaceship:AllySpaceship,bonus: Bonus,timeee: Timeee) {
        if(missileOnScreen){
            updatePosition(interval)
            //var missile_touche_vaisseau = (missile.bottom> allySpaceship.SpaceshipDebut && missile.left > allySpaceship.SpaceshipDistance && missile.right < allySpaceship.SpaceshipDistance + allySpaceship.width)
            if(missile.intersect(allySpaceship.SpaceshipDistance,allySpaceship.SpaceshipDebut,allySpaceship.SpaceshipDistance+allySpaceship.width, allySpaceship.SpaceshipFin)){
                //missileDisparait()
                joueurPerdVie(allySpaceship)
                missileOnScreen = false
                //faitQlqCh(enemySpaceship,allySpaceship,bonus,timeee)

            }
            if(allySpaceship.vie ==0){
                view.gameOver(R.string.lose)
            }
        }
    }

    fun joueurPerdVie(allySpaceship: AllySpaceship){
        allySpaceship.vie -= 1
    }

    //abstract fun faitQlqCh(enemySpaceship: EnemySpaceship,allySpaceship: AllySpaceship,bonus: Bonus,timeee: Timeee)


}