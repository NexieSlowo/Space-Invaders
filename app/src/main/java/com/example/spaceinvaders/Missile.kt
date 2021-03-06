package com.example.spaceinvaders
import android.graphics.*
import android.icu.util.DateInterval

 abstract class Missile(
    var missileLeft: Float,
    var missileTop: Float,
    var missileBottom: Float,
    var initialmissileSpeed: Float,
    var width: Float,
    var view: SpaceView
    ) : UpdatePosition {

    protected val missile= RectF(
        missileLeft,
        missileTop,
        missileLeft + width,
        missileBottom)
    protected val missilePaint    = Paint()
    protected var missileSpeed  = initialmissileSpeed
    var missileOnScreen = true
    init {missilePaint.color = Color.BLUE}


    protected fun setRect(){
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
     /*
    abstract fun updatePosition(interval : Double, enemySpaceship : EnemySpaceship, allySpaceship  : AllySpaceship, obstacle: Obstacle,timeee: Timeee)

      */
//updatePosition() va être pris de l'interface
    /*
    protected abstract fun updatePosition(
        interval       : Double)
     */

     fun reset(){
         missileOnScreen = false
     }

}


