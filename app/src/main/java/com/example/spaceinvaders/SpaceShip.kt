package com.example.spaceinvaders



import android.content.Context
import android.content.res.Resources
import android.graphics.*

abstract class SpaceShip(
    var vie: Int,
    var SpaceshipDistance: Float,
    var SpaceshipDebut: Float,
    var SpaceshipFin: Float,
    var initialSpaceshipVitesse: Float,
    var width: Float,
    var view: SpaceView,
    context: SpaceView,


    ) {

    open val spaceship= RectF(
        SpaceshipDistance, SpaceshipDebut,
        SpaceshipDistance + width, SpaceshipFin
    )
    //val spaceshipPaint = Paint()
    var spaceshipVitesse= initialSpaceshipVitesse
    val spaceshipPaint = Paint()
    init{spaceshipPaint.color = Color.WHITE}


     fun setRect() {
        spaceshipVitesse = initialSpaceshipVitesse
        spaceship.set(
            SpaceshipDistance         ,
            SpaceshipDebut            ,
            (SpaceshipDistance + width),
            SpaceshipFin)
    }

     abstract fun draw(canvas:Canvas)

     fun update(
        interval: Double){
        //Cette methode fait le mouvement
        val up = (interval * spaceshipVitesse).toFloat()
        val vaisseauToucheBord = (spaceship.left < 0 || spaceship.right > view.screenWidth)
        val decallementt: Int = 4

        deplacement_du_vaisseau(up)
         if (vaisseauToucheBord) {
            changeVitesse()
            change_distance_parcourue(interval,decallementt)
         }

        mise_a_jour_de_position_du_vaisseau(up)
    }



    /* abstract fun reset()*/

     fun deplacement_du_vaisseau(up: Float){
        spaceship.offset(up,0f)
    }

    fun changeVitesse(){
        spaceshipVitesse *= -1
    }

    fun change_distance_parcourue(interval: Double, decallement: Int){
        val up = (interval * decallement * spaceshipVitesse).toFloat()
        deplacement_du_vaisseau(up)
    }


    fun mise_a_jour_de_position_du_vaisseau(up: Float){
        SpaceshipDistance += up
    }




}
