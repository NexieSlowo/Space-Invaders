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



    fun changeVitesse(){
        spaceshipVitesse *= -1
    }


    /*open fun update(
       interval: Double){
       //Cette methode fait le mouvement
       val up = (interval * spaceshipVitesse).toFloat()
       val vaisseauToucheBord = (spaceship.left < 0 || spaceship.right > view.screenWidth)
       val decallementt: Int = 4

       deplacement_du_vaisseau(up)
        if (vaisseauToucheBord) {
           changeVitesse()
           changeDistanceParcourue(interval,decallementt)
        }

       MAJPositionVaisseau(up)
   }*/
     /*fun update(interval: Double){
         var up = (interval * spaceshipVitesse).toFloat()
         spaceship.offset(up,0f)
         if(spaceship.left < 0 ||  spaceship.right  > view.screenWidth){
             spaceshipVitesse *= -1
             up = (interval *4 * spaceshipVitesse).toFloat()
             spaceship.offset(up,0f)
         }
         SpaceshipDistance =SpaceshipDistance+up
     }*/


     fun updateBitmap(interval:Double){

         var up = (interval * spaceshipVitesse).toFloat()
         SpaceshipDistance = SpaceshipDistance+up
         if(SpaceshipDistance+view.screenWidth/4 > view.screenWidth || SpaceshipDistance < 0 ){
            spaceshipVitesse = -spaceshipVitesse
            up = (interval*3*spaceshipVitesse).toFloat()
            SpaceshipDistance = SpaceshipDistance+up
         }


    }


    /* abstract fun reset()*/

     /*fun deplacement_du_vaisseau(up: Float){
        spaceship.offset(up,0f)
    }


    fun changeDistanceParcourue(interval: Double, decallement: Int){
        val up = (interval * decallement * spaceshipVitesse).toFloat()
        deplacement_du_vaisseau(up)
    }


    fun MAJPositionVaisseau(up: Float){
        SpaceshipDistance += up
    }*/




}
