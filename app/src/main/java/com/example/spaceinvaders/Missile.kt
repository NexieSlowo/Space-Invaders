package com.example.spaceinvaders
import android.graphics.*
import android.icu.util.DateInterval

 abstract class Missile(
    var missileLeft: Float,
    var missileTop: Float,
    var missileBottom: Float,
    var initialmissileSpeed: Float,
    var width: Float,
    var view: SpaceView){

    val missile= RectF(
        missileLeft,
        missileTop,
        missileLeft + width,
        missileBottom)
     val missilePaint    = Paint()
    var missileSpeed  = initialmissileSpeed
    var missileOnScreen = true
    init {missilePaint.color = Color.BLUE}


    fun setRect(){
        missileSpeed = initialmissileSpeed
        missile.set(
            missileLeft             ,
            missileTop                ,
            missileLeft + width,
            missileBottom
        )
}

    fun draw(canvas: Canvas){
         if(missileOnScreen){
                 canvas.drawRect(missile, missilePaint)
             }
     }

//pas changer le update
    abstract fun update(interval : Double, enemySpaceship : EnemySpaceship, allySpaceship  : AllySpaceship, bonus: Bonus,timeee: Timeee)
//updatePosition() va être pris de l'interface
    abstract fun updatePosition(
        interval       : Double)

   /*  fun missileDisparait(){
         missileOnScreen = false
     }*/
     //Reset et missileDisparait() la même chose!! Tenir qu'un des deux.
     fun reset(){
         missileOnScreen = false
     }

}


