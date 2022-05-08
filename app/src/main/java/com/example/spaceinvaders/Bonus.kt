package com.example.spaceinvaders

import android.graphics.*
import kotlin.random.Random

class Bonus(
    var Distance: Float= 0f,
    var Top: Float= 0f,
    var Bottom: Float= 0f ,
    var width: Float = 300f,
    var view: SpaceView,
    context: SpaceView)

    {

    /*override fun addtime() {
        TODO("Not yet implemented")
    }*/

    var OnScreen = true
    val bonusPaint    = Paint()

    val bonus= RectF(Distance, Top, Distance + width, Bottom)
    init {bonusPaint.color = Color.WHITE}

    private var image = BitmapFactory.decodeResource(context.resources,R.drawable.bonus2)

    fun setRect() {
        bonus.set(Distance, Top, (Distance + width), (Bottom))
    }



    fun draw(canvas: Canvas) {
        if(OnScreen){
            //canvas.drawRect(bonus, bonusPaint)
            canvas.drawBitmap(image,Distance,Top,null)

        }
    }


    fun apparitionAleatoire(){
        val randomDist = Random.nextDouble(0.0,0.8).toFloat()
        val randomTop = Random.nextDouble(0.15,0.6).toFloat()

        Distance                   = randomDist*view.screenWidth
        Top                      = randomTop*view.screenHeight
        Bottom                        = Top+250
        setRect()
    }

    //override fun changetime(enemySpaceship: EnemySpaceship) {

           // view.timeLeft -= -10.0

   // }



    fun shining(){
        OnScreen = !OnScreen

    }

    }

