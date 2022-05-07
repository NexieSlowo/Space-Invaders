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

    /*open val spaceship= RectF(
        SpaceshipDistance, SpaceshipDebut,
        SpaceshipDistance + width, SpaceshipFin
    )*/
    //val spaceshipPaint = Paint()
    var spaceshipVitesse= initialSpaceshipVitesse
    val spaceshipPaint = Paint()
    init{spaceshipPaint.color = Color.WHITE}
    var lesMissiles = arrayListOf<Missile>()



    /* fun setRect() {
        spaceshipVitesse = initialSpaceshipVitesse
        spaceship.set(
            SpaceshipDistance         ,
            SpaceshipDebut            ,
            (SpaceshipDistance + width),
            SpaceshipFin)
    }*/

     abstract fun draw(canvas:Canvas)

     abstract fun reset()

    fun changeVitesse(){
        spaceshipVitesse *= -1
    }

    fun resetMissile(){
        for(i in lesMissiles){
            i.missileOnScreen = false
        }
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


    abstract fun updatePosition(interval:Double,enemySpaceship: EnemySpaceship,allySpaceship: AllySpaceship,bonus: Bonus,timeee: Timeee)


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
