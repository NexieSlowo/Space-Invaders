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
    initialspaceshipSpeed : Float     = 700f ,
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
     var allyLives = 3

    val etoile4        = Etoile (view=view, context = context)
    val etoile5        = Etoile (view=view, context = context)
    val etoile6        = Etoile (view=view, context = context)

    fun resetSpaceship(){
        allyLives = 3
        SpaceshipLeft  = (3*view.width/25f)
        SpaceshipTop     = (7800*view.height/10000f-200)
        SpaceshipBottom       = SpaceshipTop+300
    }
    fun resetEtoile(){
        etoile4.EtoileDistance           =  (5*view.width/10000f)
        etoile4.EtoileDebut              = (10900*view.height/10000f)
        etoile4.EtoileFin                = etoile4.EtoileDebut

        etoile5.EtoileDistance           = (1200*view.width/10000f)
        etoile5.EtoileDebut              = etoile4.EtoileDebut
        etoile5.EtoileFin                = etoile4.EtoileDebut

        etoile6.EtoileDistance           = (2400*view.width/10000f)
        etoile6.EtoileDebut              = etoile4.EtoileDebut
        etoile6.EtoileFin                = etoile4.EtoileDebut
    }

    override fun reset(){
        resetSpaceship()
        resetEtoile()

    }
    override fun draw(canvas: Canvas) {
        //canvas.drawRect(spaceship,spaceshipPaint)
        //canvas.drawBitmap(image, SpaceshipLeft, SpaceshipTop,null)
        for(i in theMissiles){
            i.draw(canvas)
        }
        canvas.drawBitmap(image,SpaceshipLeft,SpaceshipTop,null)
        when(allyLives){

            3 -> {
                etoile4.draw(canvas)
                etoile5.draw(canvas)
                etoile6.draw(canvas)
            }
            2 -> {
                etoile4.draw(canvas)
                etoile5.draw(canvas)
            }
            1 -> {
                etoile4.draw(canvas)
            }
        }
    }
    fun createMissileAlly() {
        theMissiles.add(
            MissileAlly(
                SpaceshipLeft,
                SpaceshipBottom,
                SpaceshipTop + view.screenWidth / 7f,
                view.screenHeight / 2f,
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
            j.update(interval,enemySpaceship,allySpaceship,bonus,timeee)
        }
        if(allyLives ==0){
            view.gameOver(R.string.lose)
        }
    }

    fun loseLife(){
        allyLives--
    }
    fun gainlife() {
        if (allyLives < 3)
            allyLives++
    }


    /*override fun update(
        interval: Double){
        var up = (interval * spaceshipSpeed).toFloat()
        spaceship.offset(up,0f)
        if(spaceship.left < 0 ||  spaceship.right  > view.screenWidth){
            spaceshipSpeed *= -1
            up = (interval *4 * spaceshipSpeed).toFloat()
            spaceship.offset(up,0f)
        }
        SpaceshipLeft =SpaceshipLeft+up
    }
*/







}