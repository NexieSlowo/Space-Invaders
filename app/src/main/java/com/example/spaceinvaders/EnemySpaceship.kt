package com.example.spaceinvaders


//Classe du vaisseau de l'enemi

import android.graphics.*
import com.example.spaceinvaders.MissileEnemy
import android.widget.Space
import java.util.*


class EnemySpaceship(

    //life                     : Int       = 3,
    SpaceshipLeft       : Float     = 0f,
    SpaceshipTop          : Float     = 0f,
    SpaceshipBottom            : Float     = 0f,
    initialSpaceshipSpeed : Float     = 900f,
    width                   : Float     = 370f,
    view                    : SpaceView,
    context                 : SpaceView):

    SpaceShip(
    //life,
    SpaceshipLeft,
    SpaceshipTop,
    SpaceshipBottom,
    initialSpaceshipSpeed,
    width,view,context){

    override var image = BitmapFactory.decodeResource(context.resources,R.drawable.deathstar2)
    //private var enemyLives = 3
    /*private val etoile1        = Etoile (view=view, context = context)
    private val etoile2        = Etoile (view=view, context = context)
    private val etoile3        = Etoile (view=view, context = context)

     */


    /*override fun draw(canvas: Canvas) {
        for(i in theMissiles){
            i.draw(canvas)
        }
        canvas.drawBitmap(image,SpaceshipLeft,SpaceshipTop,null)
        when (life){

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

    fun createMissileYellow(){
        theMissiles.add(MissileYellow(
            SpaceshipLeft+width/2,
            SpaceshipBottom,
            SpaceshipTop + view.screenWidth/7f,
            view.screenHeight*2,
            10f,
            view))
    }

    fun createMissileRed(){
        theMissiles.add(MissileRed(
            SpaceshipLeft+width/2,
            SpaceshipBottom,
            SpaceshipTop + view.screenWidth/7f,
            view.screenHeight*2,
            10f,
            view)
        )
    }
    fun createMissileGreen() {
        theMissiles.add(MissileGreen(
            SpaceshipLeft+width/2,
            SpaceshipBottom,
            SpaceshipTop + view.screenWidth/7f,
            view.screenHeight*2,
            10f,
            view)
        )
    }

    override fun updatePosition(interval:Double,enemySpaceship:EnemySpaceship,allySpaceship: AllySpaceship,obstacle: Obstacle,timeee: Timeee){
        var up = (interval * spaceshipSpeed).toFloat()
            SpaceshipLeft = SpaceshipLeft+up
            if(SpaceshipLeft+view.screenWidth/4 > view.screenWidth || SpaceshipLeft < 0 ){
                changeDirection()
                up = (interval*3*spaceshipSpeed).toFloat()
                SpaceshipLeft = SpaceshipLeft+up
            }
        for (j in theMissiles){
            j.updatePosition(interval,this,allySpaceship,obstacle,timeee)
        }
        if(life == 0){
            view.gameOver(R.string.win)
        }
    }

   /* fun loseLife(){
        life--
    }
    fun gainLife() {
        if (life < 3)
            life++
    }

    */

    override fun resetSpaceship(){
        life = 3
        SpaceshipLeft = (view.width/3f)
        SpaceshipTop    = (0.15f*view.height)
        SpaceshipBottom     = SpaceshipTop+300
        width             = 280f
    }


    override fun resetStar(){
        star1.StarLeft           = (5*view.width/10000f)
        star1.StarTop              = (2400*view.height/10000f)
        star1.StarBottom                = star1.StarTop

        star2.StarLeft           = (1200*view.width/10000f)
        star2.StarTop              = star1.StarTop
        star2.StarBottom                = star1.StarTop

        star3.StarLeft           = (2400*view.width/10000f)
        star3.StarTop              = star1.StarTop
        star3.StarTop              = star1.StarTop
    }
    /*override fun reset(){

        resetEtoile()
        resetSpaceship()

    }

     */


    }








    /*override fun reset() {
        enemySpaceshipOnScreen = false
    }*/




