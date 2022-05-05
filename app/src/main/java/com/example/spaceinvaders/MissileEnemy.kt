package com.example.spaceinvaders
import android.graphics.Canvas
import android.graphics.Color
open class MissileEnemy(missileDistance : Float, missileDebut : Float, missileFin : Float, initialMissileVitesse : Float, width:Float, view: SpaceView) : Missile(missileDistance,missileDebut,missileFin,initialMissileVitesse,width,view) {

    init {
        missilePaint.color = Color.RED
    }

    override fun deplacementMissile(interval: Double){
        var up = (interval * missileVitesse).toFloat()
        missile.offset(0f, up)
    }


    override fun update(interval :Double,enemySpaceship: EnemySpaceship,allySpaceship:AllySpaceship) {
        deplacementMissile(interval)
        var missileToucheVaisseau = (missile.bottom> allySpaceship.SpaceshipDebut && missile.left > allySpaceship.SpaceshipDistance && missile.right < allySpaceship.SpaceshipDistance + allySpaceship.width)
        if(missileToucheVaisseau){
            missileDisparait()

        }
    }


}