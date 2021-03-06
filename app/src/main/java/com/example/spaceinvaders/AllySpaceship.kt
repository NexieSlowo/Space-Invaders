package com.example.spaceinvaders

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.icu.util.DateInterval

class AllySpaceship(
    //life                     : Int       = 3    ,
    SpaceshipLeft       : Float     = 0f   ,
    SpaceshipTop          : Float     = 0f   ,
    SpaceshipBottom            : Float     = 0f   ,
    initialspaceshipSpeed : Float     = 800f ,
    width                   : Float     = 300f ,
    view                    : SpaceView        ,
    context                 : SpaceView):

    SpaceShip(
        //life                     ,
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


    override fun resetStar(){
        star1.StarLeft           =  (5*view.width/10000f)
        star1.StarTop              = (10900*view.height/10000f)
        star1.StarBottom                = star1.StarTop

        star2.StarLeft           = (1200*view.width/10000f)
        star2.StarTop              = star1.StarTop
        star2.StarBottom                = star1.StarTop

        star3.StarLeft           = (2400*view.width/10000f)
        star3.StarTop              = star1.StarTop
        star3.StarBottom                = star1.StarTop
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

    override fun updatePosition(
        interval:Double,
        enemySpaceship: EnemySpaceship,
        allySpaceship: AllySpaceship,
        obstacle: Obstacle,
        timeee: Timeee){

        // met ?? jour la position du vaisseau
        var up = (interval * spaceshipSpeed).toFloat()
        SpaceshipLeft = SpaceshipLeft+up

        // cette condition sert ?? faire rebondir le vaisseau sur le bord
        if(SpaceshipLeft+view.screenWidth/4 > view.screenWidth || SpaceshipLeft < 0 ){
            spaceshipSpeed *=-1
            up = (interval*3*spaceshipSpeed).toFloat()
            SpaceshipLeft = SpaceshipLeft+up
        }

        //met  ?? jour la position des missiles
        for (j in theMissiles){
            j.updatePosition(interval,enemySpaceship,allySpaceship,obstacle,timeee)
        }

        //si le vaisseau ?? zero vie, jeu perdu
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