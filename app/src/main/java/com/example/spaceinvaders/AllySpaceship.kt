package com.example.spaceinvaders

import android.graphics.BitmapFactory
import android.graphics.Canvas

class AllySpaceship(
    vie                     : Int       = 3,
    SpaceshipDistance       : Float     = 0f,
    SpaceshipDebut          : Float     = 0f,
    SpaceshipFin            : Float     = 0f,
    initialSpaceshipVitesse : Float     = 700f,
    width                   : Float     = 300f,
    view                    : SpaceView,
    context                 : SpaceView):

    SpaceShip(
    vie,
    SpaceshipDistance,
    SpaceshipDebut,
    SpaceshipFin,
    initialSpaceshipVitesse,
    width,
    view,
    context){
     var image = BitmapFactory.decodeResource(context.resources,R.drawable.player2)


    override fun setRect() {

        spaceship.set(
            SpaceshipDistance.toInt(), SpaceshipDebut.toInt(),
            (SpaceshipDistance + width).toInt(), SpaceshipFin.toInt()
        )
        spaceshipVitesse= initialSpaceshipVitesse

    }

    override fun draw(canvas: Canvas) {
        canvas.drawBitmap(image,SpaceshipDistance,SpaceshipFin-view.height/8,null)

    }

    override fun update(interval: Double) { //Cette methode fait le mouvement
        var up = (interval * spaceshipVitesse).toFloat()
        spaceship.offset(up.toInt(), 0)
        if (spaceship.left+view.width/20 < 0 || spaceship.right+ view.width/15.3f > view.screenWidth) {
            spaceshipVitesse *= -1
            up = (interval * 4 * spaceshipVitesse).toFloat()
            spaceship.offset(up.toInt(), 0)
        }
        SpaceshipDistance = SpaceshipDistance+up

    }

    fun changeVitesse(){
        spaceshipVitesse *= -1
    }



    /*override fun reset() {

        println("je reset")
    }*/

}