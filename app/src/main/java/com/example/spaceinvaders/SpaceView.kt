package com.example.spaceinvaders




import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView

class SpaceView @JvmOverloads constructor (context: Context, attributes: AttributeSet? = null, defStyleAttr: Int = 0): SurfaceView(context, attributes,defStyleAttr), SurfaceHolder.Callback, Runnable {
    lateinit var canvas : Canvas
    val backgroundPaint = Paint()
    var screenWidth = 0f
    var screenHeight = 0f
    var drawing = false
    lateinit var thread: Thread
    val enemySpaceship = EnemySpaceship(0f, 0f, 0f, 0f, 0f, this)
    val spaceship = SpaceShip(0f,0f,0f,0f,0f,this)
    init { //Cette méthode donne la couleur blanche au background
        backgroundPaint.color = Color.WHITE
    }

    fun pause() { //Ceci arrete l'appli quand on fait pause ou quand on sort de l'appli
        drawing = false
        thread.join()
    }

    fun resume() { //Ceci relance l'appli là où on a laissé quand on est partis
        drawing = true
        thread = Thread(this)
        thread.start()
    }

    override fun run() { //Cette fonction met en ouvre le thread, qui fait le mouvement des objets. Elle existe déjà donc on le modifie avec override.
        var previousFrameTime = System.currentTimeMillis()
        while (drawing) {
            val currentTime = System.currentTimeMillis()
            val elapsedTimeMS = (currentTime-previousFrameTime).toDouble()
            updatePositions(elapsedTimeMS) //Méthode définie plus bas qui fait le changement de la position des objets.
            draw()
            previousFrameTime = currentTime
        }
    }
    override fun onSizeChanged(w:Int, h:Int, oldw:Int, oldh:Int) { //Cette méthode sert juste pour le moment où on change de mode d'écran , par exemple quand on met en landscape, pour que les dimensions des objets s'addaptent aux nouvelles dimensions
        super.onSizeChanged(w, h, oldw, oldh)
        screenWidth = w.toFloat()
        screenHeight = h.toFloat()
        enemySpaceship.enemySpaceshipDistance = (w/4f)

        spaceship.SpaceshipDebut = (h / 1.045f)

        spaceship.SpaceshipFin = (h  / 1.055f)

        spaceship.width= (w / 6f)

        spaceship.initialSpaceshipVitesse= (h / 1f)

        spaceship.setRect()

        enemySpaceship.enemySpaceshipDistance = (w/6f)

        enemySpaceship.enemySpaceshipDebut = (h / 14f)

        enemySpaceship.enemySpaceshipFin = (h  / 16f)

        enemySpaceship.width= (w / 4f)

        enemySpaceship.initialenemySpaceshipVitesse= (h /2f)

        enemySpaceship.setRect()


    }
    fun draw() { //Ceci fait le déssin final, il se sers de draw() définis dans  enemySpaceship et Spacheship
        if (holder.surface.isValid) {
            canvas = holder.lockCanvas()
            canvas.drawRect(0f, 0f, canvas.width.toFloat(),
                canvas.height.toFloat(), backgroundPaint)
            enemySpaceship.draw(canvas)
            spaceship.draw(canvas)
            holder.unlockCanvasAndPost(canvas)
        }
    }
    fun updatePositions(elapsedTimeMS: Double) { //Ceci est la méthode qui change la position des objets, elle se sert de la méthode update() définie differament dans chaque
        val interval = elapsedTimeMS / 1000.0
        enemySpaceship.update(interval)
        spaceship.update(interval)

    }



    override fun surfaceChanged(holder: SurfaceHolder, format: Int,
                                width: Int, height: Int) {}

    override fun surfaceCreated(holder: SurfaceHolder) {}

    override fun surfaceDestroyed(holder: SurfaceHolder) {}





}
