package com.example.spaceinvaders

import android.graphics.*
import kotlin.random.Random

class Bonus(
    var Distance: Float= 0f,
    var Debut: Float= 0f,
    var Fin: Float= 0f ,
    var width: Float = 300f,
    var view: SpaceView,
    context: SpaceView)

    :InterfaceAddTime{

    override fun addtime() {
        TODO("Not yet implemented")
    }

    var OnScreen = true
    val bonusPaint    = Paint()

    val bonus= RectF(Distance, Debut, Distance + width, Fin)
    init {bonusPaint.color = Color.WHITE}

    private var image = BitmapFactory.decodeResource(context.resources,R.drawable.bonus2)

    fun setRect() {
        bonus.set(Distance, Debut, (Distance + width), (Fin))
    }



    fun draw(canvas: Canvas) {
        if(OnScreen){
            //canvas.drawRect(bonus, bonusPaint)
            canvas.drawBitmap(image,Distance,Debut,null)

        }
    }


    fun apparitionAleatoire(){
        val randomDist = Random.nextDouble(0.0,0.8).toFloat()
        val randomDebut = Random.nextDouble(0.15,0.6).toFloat()

        Distance                   = randomDist*view.screenWidth
        Debut                      = randomDebut*view.screenHeight
        Fin                        = Debut+250
        setRect()
    }

    //override fun changetime(enemySpaceship: EnemySpaceship) {

           // view.timeLeft -= -10.0

   // }



    fun shining(){
        OnScreen = !OnScreen

    }

    }

