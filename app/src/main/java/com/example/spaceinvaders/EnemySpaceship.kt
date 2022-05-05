package com.example.spaceinvaders


//Classe du vaisseau de l'enemi

import android.graphics.*
import android.widget.Space
import java.util.*


class EnemySpaceship(

    vie                     : Int       = 3,
    SpaceshipDistance       : Float     = 0f,
    SpaceshipDebut          : Float     = 0f,
    SpaceshipFin            : Float     = 0f,
    initialSpaceshipVitesse : Float     = 400f,
    width                   : Float     = 370f,
    view                    : SpaceView,
    context                 : SpaceView):

    SpaceShip(
    vie,
    SpaceshipDistance,
    SpaceshipDebut,
    SpaceshipFin,
    initialSpaceshipVitesse,
    width,view,context){

    private var image = BitmapFactory.decodeResource(context.resources,R.drawable.deathstar2)







    override fun draw(canvas: Canvas) {
        //canvas.drawRect(spaceship,spaceshipPaint)
        canvas.drawBitmap(image,SpaceshipDistance,SpaceshipDebut,null)
    }









}




    /*override fun reset() {
        enemySpaceshipOnScreen = false
    }*/




