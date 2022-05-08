package com.example.spaceinvaders

import android.graphics.*
import kotlin.random.Random

class Bonus(
    var Distance: Float= 0f,
    var Top: Float= 0f,
    var Bottom: Float= 0f ,
    var width: Float = 270f,
    var view: SpaceView,
    context: SpaceView)

    {

    /*override fun addtime() {
        TODO("Not yet implemented")
    }*/

    var OnScreen = false
    val bonusPaint    = Paint()

    val bonus= RectF(Distance, Top, Distance + width, Bottom)
    init {bonusPaint.color = Color.BLUE}

    private var image = BitmapFactory.decodeResource(context.resources,R.drawable.astero)

    fun setRect() {
        bonus.set(Distance, Top, (Distance + width), (Bottom))
    }

    fun reset(){
        OnScreen= false
        Distance                   = (1*view.width/2f)
        Top                      = (4*view.height/8f)
        Bottom                        = Top+300
        width                      = 230f
        setRect()
    }

    fun draw(canvas: Canvas) {
        if(OnScreen){
            //setRect()
            //canvas.drawRect(bonus, bonusPaint)
            canvas.drawBitmap(image,Distance,Top,null)

        }
    }


    fun apparitionAleatoire(){
        val randomDist = Random.nextDouble(0.0,0.8).toFloat()
        val randomTop = Random.nextDouble(0.2,0.5).toFloat()

        Distance                   = randomDist*view.screenWidth
        Top                      = randomTop*view.screenHeight
        Bottom                        = Top+220
        setRect()
    }

    //override fun changetime(enemySpaceship: EnemySpaceship) {

           // view.timeLeft -= -10.0

   // }



    fun shining(){
        OnScreen = !OnScreen

    }

    }

