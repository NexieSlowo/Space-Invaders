package com.example.spaceinvaders


//Classe du vaisseau de l'enemi

import android.graphics.*
import android.widget.Space
import java.util.*


class EnemySpaceship( SpaceshipDistance: Float, SpaceshipDebut: Float, SpaceshipFin: Float,  initialSpaceshipVitesse: Float, width: Float,  view: SpaceView, context:SpaceView):SpaceShip(SpaceshipDistance, SpaceshipDebut, SpaceshipFin, initialSpaceshipVitesse, width , view, context)
{




     var image = BitmapFactory.decodeResource(context.resources,R.drawable.deathstar2)




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
        SpaceshipDistance = SpaceshipDistance + up

    }

    override fun interact(missile:Missile) {


    }



}
