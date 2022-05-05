package com.example.spaceinvaders
import android.graphics.*
import android.icu.util.DateInterval

open abstract class Missile(
    var missileDistance: Float,
    var missileDebut: Float,
    var missileFin: Float,
    var initialMissileVitesse: Float,
    var width: Float,
    var view: SpaceView){

    val missile= RectF(
        missileDistance,
        missileDebut,
        missileDistance + width,
        missileFin)


    val missilePaint    = Paint()
    var missileVitesse  = initialMissileVitesse
    var missileOnScreen = true
    init {missilePaint.color = Color.BLUE}

    fun missileDisparait(){
        missileOnScreen = false
    }

    fun setRect(){
        if(missileOnScreen){
            missileVitesse = initialMissileVitesse
            missile.set(
                missileDistance,
                missileDebut,
                missileDistance + width,
                missileFin)}
        else{
            missileDistance = 0f
            missileDebut = 0f
            missileFin = 0f
            width = 0f
            initialMissileVitesse = 0f
        }
}


     fun draw(canvas: Canvas){
         if(missileOnScreen){
             canvas.drawRect(missile, missilePaint)}}


    abstract fun update(
        interval       : Double,
        enemySpaceship : EnemySpaceship,
        allySpaceship  : AllySpaceship)

    abstract fun deplacementMissile(
        interval       : Double)






}

