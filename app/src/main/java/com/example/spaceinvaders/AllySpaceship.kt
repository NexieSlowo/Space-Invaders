package com.example.spaceinvaders

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.icu.util.DateInterval

class AllySpaceship(
    vie                     : Int       = 3    ,
    SpaceshipDistance       : Float     = 0f   ,
    SpaceshipDebut          : Float     = 0f   ,
    SpaceshipFin            : Float     = 0f   ,
    initialSpaceshipVitesse : Float     = 700f ,
    width                   : Float     = 300f ,
    view                    : SpaceView        ,
    context                 : SpaceView):

    SpaceShip(
        vie                     ,
        SpaceshipDistance       ,
        SpaceshipDebut          ,
        SpaceshipFin            ,
        initialSpaceshipVitesse ,
        width                   ,
        view                    ,
        context){


    private var motionx = 0f
    private var motiony = view.screenHeight
    private var image = BitmapFactory.decodeResource(
        context.resources,
        R.drawable.player2)



    override fun draw(canvas: Canvas) {
        //canvas.drawRect(spaceship,spaceshipPaint)
        //canvas.drawBitmap(image, SpaceshipDistance, SpaceshipDebut,null)
        canvas.drawBitmap(image,SpaceshipDistance,(view.screenHeight-350f).toFloat(),null)
    }



    override fun updateBitmap(interval:Double){
        var up = (interval * spaceshipVitesse).toFloat()
        SpaceshipDistance = SpaceshipDistance+up
        if(SpaceshipDistance+view.screenWidth/4 > view.screenWidth || SpaceshipDistance < 0 ){
            spaceshipVitesse *=-1
            up = (interval*3*spaceshipVitesse).toFloat()
            SpaceshipDistance = SpaceshipDistance+up
        }

    }



    /*override fun update(
        interval: Double){
        var up = (interval * spaceshipVitesse).toFloat()
        spaceship.offset(up,0f)
        if(spaceship.left < 0 ||  spaceship.right  > view.screenWidth){
            spaceshipVitesse *= -1
            up = (interval *4 * spaceshipVitesse).toFloat()
            spaceship.offset(up,0f)
        }
        SpaceshipDistance =SpaceshipDistance+up
    }
*/







}