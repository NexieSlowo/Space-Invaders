package com.example.spaceinvaders


//Classe du vaisseau de l'enemi

import android.graphics.*
import android.widget.Space
import java.util.*


class EnemySpaceship (var enemySpaceshipDistance: Float, var enemySpaceshipDebut: Float, var enemySpaceshipFin: Float, var initialenemySpaceshipVitesse: Float, var width: Float, var view: SpaceView,context:SpaceView)
{
    val enemySpaceship= Rect(enemySpaceshipDistance.toInt(), enemySpaceshipDebut.toInt(),
        (enemySpaceshipDistance + width).toInt(), enemySpaceshipFin.toInt()
    )
    val enemySpaceshipPaint = Paint()
    var enemySpaceshipVitesse= initialenemySpaceshipVitesse
    var image = BitmapFactory.decodeResource(context.resources,R.drawable.darthstar2)


    fun setRect() { //Méthode qui crée le rectangle qui caracterise le vaisseau
        enemySpaceship.set(
            enemySpaceshipDistance.toInt(), enemySpaceshipDebut.toInt(),
            (enemySpaceshipDistance + width).toInt(), enemySpaceshipFin.toInt()
        )
        enemySpaceshipVitesse= initialenemySpaceshipVitesse //set est une méthode qui existe déjà, on l'utilise sur l'objet enemySpaceship qui est un rectangle crée comme valeur en haut
    }


    fun draw(canvas: Canvas) { //Ceci déssine le rectangle, mais pour vraiment déssiner il faut s'aider de la classe spaceview qui s'occupe de l'apparence de la page
        //enemySpaceshipPaint.color = Color.RED //On défini la couleur du rectangle
        //canvas.drawRect(enemySpaceship, enemySpaceshipPaint) //drawRect est une méthode qui existe déjà et qui dessine des rectangles, les coord sont données en argument
        canvas.drawBitmap(image,enemySpaceshipDistance,enemySpaceshipFin-view.height/8,null)
    }

    fun update(interval: Double) { //Cette methode fait le mouvement
        var up = (interval * enemySpaceshipVitesse).toFloat()
        enemySpaceship.offset(up.toInt(), 0) //Offset est une méthode qui existe déjà et qui fait qu'un objet bouge avec la vitesse donnée en argument
        if (enemySpaceship.left < 0 || enemySpaceship.right > view.screenWidth) { //Si le rectangle touche les côtés du screen
            enemySpaceshipVitesse *= -1 //La vitesse prend la direction contraire
            up = (interval * 3 * enemySpaceshipVitesse).toFloat() //Redifintion de la vitesse
            enemySpaceship.offset(up.toInt(), 0) //On appelle offset de nouveau avec la nouvelle vitesse

        }
        enemySpaceshipDistance = enemySpaceshipDistance+up
    }
}