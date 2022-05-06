package com.example.spaceinvaders
import android.graphics.*
import android.icu.util.DateInterval

open abstract class Missile(
    var missileDistance: Float,
    var missileDebut: Float,
    var missileFin: Float,
    var initialMissileVitesse: Float,
    var width: Float,
    var view: SpaceView){

    val missile= RectF(
        missileDistance,
        missileDebut,
        missileDistance + width,
        missileFin)


    val missilePaint    = Paint()
    var missileVitesse  = initialMissileVitesse
    var missileOnScreen = true
    init {missilePaint.color = Color.BLUE}

    fun missileDisparait(){
        missileOnScreen = false
    }
 //Reset et missileDisparait() la même chose!! Tenir qu'un des deux.
    fun reset(){
        missileOnScreen = false
    }
    fun setRect(){
        missileVitesse = initialMissileVitesse
        missile.set(
            missileDistance             ,
            missileDebut                ,
            missileDistance + width,
            missileFin
        )
}


     fun draw(canvas: Canvas){
         if(missileOnScreen){
                 canvas.drawRect(missile, missilePaint)
             }
     }


    abstract fun update(interval : Double, enemySpaceship : EnemySpaceship, allySpaceship  : AllySpaceship, bonus: Bonus,timeee: Timeee)

    abstract fun updatePosition(
        interval       : Double)






}

