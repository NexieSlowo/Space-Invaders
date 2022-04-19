package com.example.spaceinvaders


//Classe du vaisseau de l'enemi

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import java.util.*


class EnemySpaceship (var enemySpaceshipDistance: Float, var enemySpaceshipDebut: Float, var enemySpaceshipFin: Float, var initialenemySpaceshipVitesse: Float, var width: Float, var view: SpaceView)
{
    val enemySpaceship= RectF(enemySpaceshipDistance, enemySpaceshipDebut,
        enemySpaceshipDistance + width, enemySpaceshipFin)
    val enemySpaceshipPaint = Paint()
    var enemySpaceshipVitesse= initialenemySpaceshipVitesse

    fun setRect() { //Méthode qui crée le rectangle qui caracterise le vaisseau
        enemySpaceship.set(enemySpaceshipDistance, enemySpaceshipDebut,
            enemySpaceshipDistance + width, enemySpaceshipFin)
        enemySpaceshipVitesse= initialenemySpaceshipVitesse //set est une méthode qui existe déjà, on l'utilise sur l'objet enemySpaceship qui est un rectangle crée comme valeur en haut
    }


    fun draw(canvas: Canvas) { //Ceci déssine le rectangle, mais pour vraiment déssiner il faut s'aider de la classe spaceview qui s'occupe de l'apparence de la page
        enemySpaceshipPaint.color = Color.RED //On défini la couleur du rectangle
        canvas.drawRect(enemySpaceship, enemySpaceshipPaint) //drawRect est une méthode qui existe déjà et qui dessine des rectangles, les coord sont données en argument
    }

    fun update(interval: Double) { //Cette methode fait le mouvement
        var up = (interval * enemySpaceshipVitesse).toFloat()
        enemySpaceship.offset(up, 0f) //Offset est une méthode qui existe déjà et qui fait qu'un objet bouge avec la vitesse donnée en argument
        if (enemySpaceship.left < 0 || enemySpaceship.right > view.screenWidth) { //Si le rectangle touche les côtés du screen
            enemySpaceshipVitesse *= -1 //La vitesse prend la direction contraire
            up = (interval * 3 * enemySpaceshipVitesse).toFloat() //Redifintion de la vitesse
            enemySpaceship.offset(up, 0f) //On appelle offset de nouveau avec la nouvelle vitesse
        }
    }
}