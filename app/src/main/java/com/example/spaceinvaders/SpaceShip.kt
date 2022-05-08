package com.example.spaceinvaders



import android.content.Context
import android.content.res.Resources
import android.graphics.*

abstract class SpaceShip(
    var vie: Int,
    var SpaceshipLeft: Float,
    var SpaceshipTop: Float,
    var SpaceshipBottom: Float,
    var initialSpaceshipSpeed: Float,
    var width: Float,
    var view: SpaceView,
    context: SpaceView,


    ) {

    var spaceshipSpeed= initialSpaceshipSpeed
    var theMissiles = arrayListOf<Missile>()
    abstract val image : Bitmap
    protected val etoile1        = Etoile (view=view, context = context)
    protected val etoile2        = Etoile (view=view, context = context)
    protected val etoile3        = Etoile (view=view, context = context)
    protected var life           =3




     fun draw(canvas: Canvas) {

        for(i in theMissiles){
            i.draw(canvas)
        }
        canvas.drawBitmap(image,SpaceshipLeft,SpaceshipTop,null)
        when(life){

            3 -> {
                etoile1.draw(canvas)
                etoile2.draw(canvas)
                etoile3.draw(canvas)
            }
            2 -> {
                etoile1.draw(canvas)
                etoile2.draw(canvas)
            }
            1 -> {
                etoile1.draw(canvas)
            }
        }
    }


    fun resetMissile(){
        for(i in theMissiles){
            i.missileOnScreen = false
        }
    }

    fun changeDirection(){
        spaceshipSpeed *= -1
    }


    fun loseLife(){
        life--
    }


    fun gainLife() {
        if (life < 3)
            life++
    }


    fun reset(){

        resetEtoile()
        resetSpaceship()

    }


    abstract fun resetSpaceship()
    abstract fun resetEtoile()


    abstract fun updatePosition(interval:Double,enemySpaceship: EnemySpaceship,allySpaceship: AllySpaceship,bonus: Bonus,timeee: Timeee)






}
