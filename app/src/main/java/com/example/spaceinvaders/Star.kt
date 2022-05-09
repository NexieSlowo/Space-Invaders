package com.example.spaceinvaders

import android.graphics.*

class Star(
    var StarLeft: Float= 0f,
    var StarTop: Float= 0f,
    var StarBottom: Float= 0f ,
    var width: Float = 300f,
    var view: SpaceView,
    context: SpaceView){



    /*val etoile= RectF(
        EtoileDistance,
        EtoileDebut,
        EtoileDistance + width,
        EtoileFin)

     */

    var image = BitmapFactory.decodeResource(context.resources,R.drawable.star2)

    /*fun setRect() {
        etoile.set(
            EtoileDistance, EtoileDebut,
            (EtoileDistance + width), (EtoileFin))}

     */



    fun draw(canvas: Canvas) {
        canvas.drawBitmap(image,StarLeft,StarTop-view.screenHeight/5,null)
    }
}