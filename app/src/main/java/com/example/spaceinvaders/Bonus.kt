package com.example.spaceinvaders

import android.graphics.*

class Bonus(
    var Distance: Float= 0f,
    var Debut: Float= 0f,
    var Fin: Float= 0f ,
    var width: Float = 300f,
    var view: SpaceView,
    context: SpaceView){

    val bonus= RectF(
        Distance,
        Debut,
        Distance + width,
        Fin)

    var image = BitmapFactory.decodeResource(context.resources,R.drawable.bonus2)

    fun setRect() {
        bonus.set(
            Distance, Debut,
            (Distance + width), (Fin))}



    fun draw(canvas: Canvas) {
        canvas.drawBitmap(image,Distance,Debut-view.screenHeight/5,null)}}