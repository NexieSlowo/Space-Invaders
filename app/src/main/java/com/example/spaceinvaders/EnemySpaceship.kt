package com.example.spaceinvaders


//Classe du vaisseau de l'enemi

import android.graphics.*
import com.example.spaceinvaders.MissileEnemy
import android.widget.Space
import java.util.*


class EnemySpaceship(

    vie                     : Int       = 3,
    SpaceshipDistance       : Float     = 0f,
    SpaceshipDebut          : Float     = 0f,
    SpaceshipFin            : Float     = 0f,
    initialSpaceshipVitesse : Float     = 400f,
    width                   : Float     = 370f,
    view                    : SpaceView,
    context                 : SpaceView):

    SpaceShip(
    vie,
    SpaceshipDistance,
    SpaceshipDebut,
    SpaceshipFin,
    initialSpaceshipVitesse,
    width,view,context){

    private var image = BitmapFactory.decodeResource(context.resources,R.drawable.deathstar2)
    //var lesMissilesJaunes = arrayListOf<MissileJaune>()
    //var lesMissilesVerts = arrayListOf<MissileVert>()
    //var lesMissilesRouges = arrayListOf<MissileRouge>()
    //var lesMissilesEnnemi = arrayListOf<MissileEnemy>()

    //lateinit var allySpaceship: AllySpaceship
    //lateinit var bonus : Bonus
    //lateinit var timeee : Timeee

    override fun reset(){
        vie = 3
        SpaceshipDistance = (view.width/3f)
        SpaceshipDebut    = (0.15f*view.height)
        SpaceshipFin      = SpaceshipDebut+300
        width             = 280f
        //setRect()
    }
    override fun draw(canvas: Canvas) {
        //canvas.drawRect(spaceship,spaceshipPaint)
        for(i in lesMissiles){
            i.draw(canvas)
        }
        canvas.drawBitmap(image,SpaceshipDistance,SpaceshipDebut,null)
    }
    fun createMissileJaune(){
        lesMissiles.add(MissileJaune(SpaceshipDistance,
            SpaceshipFin,
            SpaceshipDebut + view.screenWidth/7f,
            view.screenHeight/2f,
            10f,
            view))
    }
    fun createMissileRouge(){
        lesMissiles.add(MissileRouge(SpaceshipDistance,
            SpaceshipFin,
            SpaceshipDebut + view.screenWidth/7f,
            view.screenHeight/2f,
            10f,
            view)
        )
    }
    fun createMissileVerte() {
        lesMissiles.add(MissileVert(SpaceshipDistance,
            SpaceshipFin,
            SpaceshipDebut + view.screenWidth/7f,
            view.screenHeight/2f,
            10f,
            view)
        )
    }

    override fun updatePosition(interval:Double,enemySpaceship:EnemySpaceship,allySpaceship: AllySpaceship,bonus: Bonus,timeee: Timeee){
        var up = (interval * spaceshipVitesse).toFloat()
            SpaceshipDistance = SpaceshipDistance+up
            if(SpaceshipDistance+view.screenWidth/4 > view.screenWidth || SpaceshipDistance < 0 ){
                spaceshipVitesse = -spaceshipVitesse
                up = (interval*3*spaceshipVitesse).toFloat()
                SpaceshipDistance = SpaceshipDistance+up
            }
        for (j in lesMissiles){
            j.update(interval,this,allySpaceship,bonus,timeee)
        }
    }


    }








    /*override fun reset() {
        enemySpaceshipOnScreen = false
    }*/




