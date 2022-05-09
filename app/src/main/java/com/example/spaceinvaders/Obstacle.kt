package com.example.spaceinvaders

import android.graphics.*
import kotlin.random.Random

class Obstacle(
    var Left: Float= 0f,
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
    val obstaclePaint    = Paint()

    val obstacle= RectF(Left, Top, Left + width, Bottom)
    init {obstaclePaint.color = Color.BLUE}

    private var image = BitmapFactory.decodeResource(context.resources,R.drawable.astero)

    fun setRect() {
        obstacle.set(Left, Top, (Left + width), (Bottom))
    }

    fun reset(){
        OnScreen= false
        Left                   = (1*view.width/2f)
        Top                      = (4*view.height/8f)
        Bottom                        = Top+300
        width                      = 230f
        setRect()
    }

    fun draw(canvas: Canvas) {
        if(OnScreen){
            //setRect()
            //canvas.drawRect(obstacle, obstaclePaint)
            canvas.drawBitmap(image,Left,Top,null)

        }
    }


    fun randomAppearance(){
        val randomDist = Random.nextDouble(0.0,0.8).toFloat()
        val randomTop = Random.nextDouble(0.2,0.5).toFloat()

        Left                   = randomDist*view.screenWidth
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

