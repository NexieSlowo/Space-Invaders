package com.example.spaceinvaders

/*import android.graphics.*
import android.icu.util.DateInterval
import android.widget.Space
import java.util.*

class Missile (x:Float, y:Float, diametre:Float,var view : SpaceView) {
    lateinit var spaceview: SpaceView
    lateinit var ennemi : EnemySpaceship
    val missile = Missile(0f,0f,diametre,view)
    var r = RectF(x,y,x+diametre,y+diametre)
    var random = Random()
    var missileVitesse = 0f
    val paint = Paint()
    var color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
    var missileOnScreen = true
    var missilediametre = diametre
    var missilePaint = Paint()
    var dx: Int
    var dy: Int
    init {
        if (random.nextDouble() > 0.5) dx = 1 else dx = -1
        if (random.nextDouble() < 0.5) dy = 1 else dy = -1
    }

    init {
        missilePaint.color = Color.RED
    }
    fun draw(canvas: Canvas?) { //En gros quand on veut que du texte s'affiche sur la balle, il faut le déssiner différament, donc la fonction pour montrer du texte doit être mise dans la fonction qui déssine

        paint.color = color
        canvas?.drawOval(r, paint)}

    fun update(lesMissiles ){
        r.offset(0f,50f)




    }

}*/

import android.graphics.*

class Missile(var missileDistance: Float, var missileDebut: Float, var missileFin: Float, var initialMissileVitesse: Float, var width: Float, var view: SpaceView, ) {

    val missile= RectF(missileDistance, missileDebut,
        missileDistance + width, missileFin)
    val missilePaint = Paint()
    var missileVitesse= initialMissileVitesse

    fun setRect() {
        missile.set(missileDistance, missileDebut,
            missileDistance + width, missileFin)
        missileVitesse= initialMissileVitesse
    }


    fun draw(canvas: Canvas) {
        missilePaint.color = Color.BLUE
        canvas.drawRect(missile, missilePaint)
    }

    fun update(interval: Double) {
        lateinit var spaceShip: SpaceShip
        var up = (interval * missileVitesse).toFloat()
        missile.offset(0f, -up)
        /*if (missile.top>enemySpaceship.enemySpaceshipFin
            && missile.left > enemySpaceship.enemySpaceshipDistance && missileDistance+ ) {
            cible.detectChoc(this)
        //if (missile.top < 0 || missile.bottom > view.screenHeight) {
            //missileVitesse *= -1
           // up = (interval * 3 * missileVitesse).toFloat()
            //missile.offset(0f,up)
        //}*/
    }
}

