package com.example.spaceinvaders

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.icu.util.DateInterval

class AllySpaceship(
    vie                     : Int       = 3    ,
    SpaceshipLeft       : Float     = 0f   ,
    SpaceshipTop          : Float     = 0f   ,
    SpaceshipBottom            : Float     = 0f   ,
    initialspaceshipSpeed : Float     = 800f ,
    width                   : Float     = 300f ,
    view                    : SpaceView        ,
    context                 : SpaceView):

    SpaceShip(
        vie                     ,
        SpaceshipLeft       ,
        SpaceshipTop          ,
        SpaceshipBottom            ,
        initialspaceshipSpeed ,
        width                   ,
        view                    ,
        context){


    override val image = BitmapFactory.decodeResource(
        context.resources,
        R.drawable.player2)
     //var allyLives = 3

    /*val etoile1        = Etoile (view=view, context = context)
    val etoile2        = Etoile (view=view, context = context)
    val etoile3        = Etoile (view=view, context = context)*/

    override fun resetSpaceship(){
        life = 3
        SpaceshipLeft  = (3*view.width/25f)
        SpaceshipTop     = (7800*view.height/10000f-200)
        SpaceshipBottom       = SpaceshipTop+300
    }


    override fun resetEtoile(){
        etoile1.EtoileDistance           =  (5*view.width/10000f)
        etoile1.EtoileDebut              = (10900*view.height/10000f)
        etoile1.EtoileFin                = etoile1.EtoileDebut

        etoile2.EtoileDistance           = (1200*view.width/10000f)
        etoile2.EtoileDebut              = etoile1.EtoileDebut
        etoile2.EtoileFin                = etoile1.EtoileDebut

        etoile3.EtoileDistance           = (2400*view.width/10000f)
        etoile3.EtoileDebut              = etoile1.EtoileDebut
        etoile3.EtoileFin                = etoile1.EtoileDebut
    }

   /* override fun reset(){
        resetSpaceship()
        resetEtoile()

    }

    */
  /*  override fun draw(canvas: Canvas) {
        //canvas.drawRect(spaceship,spaceshipPaint)
        //canvas.drawBitmap(image, SpaceshipLeft, SpaceshipTop,null)
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

   */
    fun createMissileAlly() {
        theMissiles.add(
            MissileAlly(
                SpaceshipLeft+width/2,
                SpaceshipBottom*1,
                SpaceshipTop + view.screenWidth / 7f,
                view.screenHeight *2f,
                10f,
                view
            )
        )
    }

    override fun updatePosition(interval:Double,enemySpaceship: EnemySpaceship,allySpaceship: AllySpaceship,bonus: Bonus,timeee: Timeee){

        var up = (interval * spaceshipSpeed).toFloat()
        SpaceshipLeft = SpaceshipLeft+up
        if(SpaceshipLeft+view.screenWidth/4 > view.screenWidth || SpaceshipLeft < 0 ){
            spaceshipSpeed *=-1
            up = (interval*3*spaceshipSpeed).toFloat()
            SpaceshipLeft = SpaceshipLeft+up
        }
        for (j in theMissiles){
            j.updatePosition(interval,enemySpaceship,allySpaceship,bonus,timeee)
        }
        if(life ==0){
            view.gameOver(R.string.lose)
        }
    }

    /*fun loseLife(){
        life--
    }
    fun gainLife() {
        if (life < 3)
            life++
    }

     */



}