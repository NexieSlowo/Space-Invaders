package com.example.spaceinvaders

import android.graphics.BitmapFactory
import android.graphics.Canvas

class AllySpaceship(
    vie                     : Int       = 3    ,
    SpaceshipDistance       : Float     = 0f   ,
    SpaceshipDebut          : Float     = 0f   ,
    SpaceshipFin            : Float     = 0f   ,
    initialSpaceshipVitesse : Float     = 700f ,
    width                   : Float     = 300f ,
    view                    : SpaceView        ,
    context                 : SpaceView):

    SpaceShip(
        vie                     ,
        SpaceshipDistance       ,
        SpaceshipDebut          ,
        SpaceshipFin            ,
        initialSpaceshipVitesse ,
        width                   ,
        view                    ,
        context){

    private var image = BitmapFactory.decodeResource(
        context.resources,
        R.drawable.player2)

    override fun setRect() {
        spaceshipVitesse = initialSpaceshipVitesse
        spaceship.set(
            SpaceshipDistance.toInt()          ,
            SpaceshipDebut.toInt()             ,
            (SpaceshipDistance + width).toInt(),
            SpaceshipFin.toInt())
    }

    override fun draw(
        canvas: Canvas) {
        canvas.drawBitmap(
            image                          ,
            SpaceshipDistance              ,
            SpaceshipFin-view.height/8 ,
            null)
    }
/*
    override fun update(
        interval: Double){
        //Cette methode fait le mouvement
        val up = (interval * spaceshipVitesse).toFloat()
        var vaisseau_touche_bord = (spaceship.left+view.width/20 < 0 || spaceship.right+ view.width/15.3f > view.screenWidth)

        deplacement_du_vaisseau(up)
        if (vaisseau_touche_bord) {
            changeVitesse()
            change_distance_parcourue(interval)
        }
        mise_a_jour_de_position_du_vaisseau(up)
    }

 */

    override fun update(
        interval: Double){
        var up = (interval * spaceshipVitesse).toFloat()
        spaceship.offset(up.toInt(),0)
        if(spaceship.left+view.width/20 < 0 ||  spaceship.right + view.width/15.3f > view.screenWidth){
            spaceshipVitesse *= -1
            up = (interval *4 * spaceshipVitesse).toFloat()
            spaceship.offset(up.toInt(),0)
        }
        SpaceshipDistance =SpaceshipDistance+up
    }



    override fun deplacement_du_vaisseau(
        up: Float){
        spaceship.offset(up.toInt(),0)
    }

    fun changeVitesse(){
        spaceshipVitesse *= -1
    }

    fun change_distance_parcourue(
        interval: Double){
        val up = (interval * 4 * spaceshipVitesse).toFloat()
        deplacement_du_vaisseau(up)
    }


    fun mise_a_jour_de_position_du_vaisseau(up: Float){
        SpaceshipDistance += up
    }

    /*override fun reset() {

        println("je reset")
    }*/

}