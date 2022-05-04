package com.example.spaceinvaders

import android.graphics.*

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

    var bonusOnScreen = false
    val bonusPaint    = Paint()

    val bonus= RectF(Distance, Debut, Distance + width, Fin)
    init {bonusPaint.color = Color.WHITE}

    private var image = BitmapFactory.decodeResource(context.resources,R.drawable.bonus2)

    fun setRect() {
        bonus.set(
            Distance, Debut,
            (Distance + width), (Fin))
    }



    fun draw(canvas: Canvas) {
        if(bonusOnScreen){
            canvas.drawRect(bonus, bonusPaint)
            canvas.drawBitmap(image,Distance,Debut,null)
        }
    }






    fun shining(){
        bonusOnScreen = !bonusOnScreen

    }

    }

