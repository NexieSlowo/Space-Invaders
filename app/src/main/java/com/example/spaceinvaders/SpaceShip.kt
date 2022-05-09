package com.example.spaceinvaders



import android.content.Context
import android.content.res.Resources
import android.graphics.*

abstract class SpaceShip(
    //var life: Int,
    var SpaceshipLeft: Float,
    var SpaceshipTop: Float,
    var SpaceshipBottom: Float,
    var initialSpaceshipSpeed: Float,
    var width: Float,
    var view: SpaceView,
    context: SpaceView,


    ) : UpdatePosition {

    var spaceshipSpeed= initialSpaceshipSpeed
    var theMissiles = arrayListOf<Missile>()
    abstract val image : Bitmap
    protected val star1        = Star (view=view, context = context)
    protected val star2        = Star (view=view, context = context)
    protected val star3        = Star (view=view, context = context)
    protected var life           =3
    var invincible = false



     fun draw(canvas: Canvas) {

        for(i in theMissiles){
            i.draw(canvas)
        }
        canvas.drawBitmap(image,SpaceshipLeft,SpaceshipTop,null)
        when(life){

            3 -> {
                star1.draw(canvas)
                star2.draw(canvas)
                star3.draw(canvas)
            }
            2 -> {
                star1.draw(canvas)
                star2.draw(canvas)
            }
            1 -> {
                star1.draw(canvas)
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
        if(!invincible){life--}

    }


    fun gainLife() {
        if(!invincible){
            if (life < 3)
                life++
        }
    }


    fun reset(){

        resetStar()
        resetSpaceship()

    }


    abstract fun resetSpaceship()
    abstract fun resetStar()

/*
    abstract fun updatePosition(interval:Double,enemySpaceship: EnemySpaceship,allySpaceship: AllySpaceship,bonus: Bonus,timeee: Timeee)


 */





}
