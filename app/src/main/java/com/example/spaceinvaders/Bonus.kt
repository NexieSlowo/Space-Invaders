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
    init {bonusPaint.color = Color.WHITE}
    val bonus= RectF(
        Distance,
        Debut,
        Distance + width,
        Fin)

    private var image = BitmapFactory.decodeResource(context.resources,R.drawable.bonus2)

    fun setRect() {
        if (bonusOnScreen){
            bonus.set(
                Distance, Debut,
                (Distance + width), (Fin))}
        else {
            Distance =0f
            Debut =0f
            width = 0f
            Fin = 0f
        }
    }



    fun draw(canvas: Canvas) {
        if(bonusOnScreen){
            canvas.drawBitmap(image,Distance,Debut-view.screenHeight/5,null)}}



    fun drawRectangle(canvas: Canvas){
        if(bonusOnScreen){
            canvas.drawRect(bonus, bonusPaint)}}

    fun shining(){
        bonusOnScreen = !bonusOnScreen

    }

    }

