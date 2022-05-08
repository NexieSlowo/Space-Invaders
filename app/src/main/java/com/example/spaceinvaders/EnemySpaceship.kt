package com.example.spaceinvaders


//Classe du vaisseau de l'enemi

import android.graphics.*
import com.example.spaceinvaders.MissileEnemy
import android.widget.Space
import java.util.*


class EnemySpaceship(

    vie                     : Int       = 3,
    SpaceshipLeft       : Float     = 0f,
    SpaceshipTop          : Float     = 0f,
    SpaceshipBottom            : Float     = 0f,
    initialSpaceshipSpeed : Float     = 400f,
    width                   : Float     = 370f,
    view                    : SpaceView,
    context                 : SpaceView):

    SpaceShip(
    vie,
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

    fun createMissileJaune(){
        theMissiles.add(MissileJaune(
            SpaceshipLeft+width/2,
            SpaceshipBottom,
            SpaceshipTop + view.screenWidth/7f,
            view.screenHeight*2,
            10f,
            view))
    }

    fun createMissileRouge(){
        theMissiles.add(MissileRouge(
            SpaceshipLeft+width/2,
            SpaceshipBottom,
            SpaceshipTop + view.screenWidth/7f,
            view.screenHeight*2,
            10f,
            view)
        )
    }
    fun createMissileVerte() {
        theMissiles.add(MissileVert(
            SpaceshipLeft+width/2,
            SpaceshipBottom,
            SpaceshipTop + view.screenWidth/7f,
            view.screenHeight*2,
            10f,
            view)
        )
    }

    override fun updatePosition(interval:Double,enemySpaceship:EnemySpaceship,allySpaceship: AllySpaceship,bonus: Bonus,timeee: Timeee){
        var up = (interval * spaceshipSpeed).toFloat()
            SpaceshipLeft = SpaceshipLeft+up
            if(SpaceshipLeft+view.screenWidth/4 > view.screenWidth || SpaceshipLeft < 0 ){
                changeDirection()
                up = (interval*3*spaceshipSpeed).toFloat()
                SpaceshipLeft = SpaceshipLeft+up
            }
        for (j in theMissiles){
            j.updatePosition(interval,this,allySpaceship,bonus,timeee)
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


    override fun resetEtoile(){
        etoile1.EtoileDistance           = (5*view.width/10000f)
        etoile1.EtoileDebut              = (2400*view.height/10000f)
        etoile1.EtoileFin                = etoile1.EtoileDebut

        etoile2.EtoileDistance           = (1200*view.width/10000f)
        etoile2.EtoileDebut              = etoile1.EtoileDebut
        etoile2.EtoileFin                = etoile1.EtoileDebut

        etoile3.EtoileDistance           = (2400*view.width/10000f)
        etoile3.EtoileDebut              = etoile1.EtoileDebut
        etoile3.EtoileDebut              = etoile1.EtoileDebut
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




