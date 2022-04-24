package com.example.spaceinvaders




import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView


class SpaceView @JvmOverloads constructor (context: Context, attributes: AttributeSet? = null, defStyleAttr: Int = 0): SurfaceView(context, attributes,defStyleAttr), SurfaceHolder.Callback, Runnable {
    lateinit var canvas : Canvas
    val backgroundPaint = Paint()
    var screenWidth = 0f
    var screenHeight = 0f
    var drawing = false
    lateinit var thread: Thread
    val enemySpaceship = EnemySpaceship(0f, 0f, 0f, 0f, 0f, this,this)

    val missile = Missile(0f,0f,0f,0f,0f,this)

    val spaceship = SpaceShip(0f, 0f, 0f, 0f, 0f, this,this)
    val lesMissiles = arrayListOf<Missile>()

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
        enemySpaceship.enemySpaceshipDistance = (w/5f)
        enemySpaceship.enemySpaceshipDebut = (h / 3f)
        enemySpaceship.enemySpaceshipFin = (h  / 5f)
        enemySpaceship.width= (w / 4f)
        enemySpaceship.initialenemySpaceshipVitesse= (h /2f)
        enemySpaceship.setRect()

        spaceship.SpaceshipDistance = (w/6f)
        spaceship.SpaceshipDebut = (h / 1.045f)
        spaceship.SpaceshipFin = (h  / 1.055f)
        spaceship.width= (w / 6f)
        spaceship.initialSpaceshipVitesse= (h / 1.5f)
        spaceship.setRect()


        missile.missileDistance = (w/6f)
        missile.initialMissileVitesse = (h / 1.5f)
        missile.missileDebut = (h / 1.2f)
        missile.missileFin = (h  / 1.055f)
        missile.width= (w / 15f)
        missile.setRect()




    }
    fun draw() { //Ceci fait le déssin final, il se sers de draw() définis dans  enemySpaceship et Spacheship
        if (holder.surface.isValid) {
            canvas = holder.lockCanvas()
            canvas.drawRect(0f, 0f, canvas.width.toFloat(),
                canvas.height.toFloat(), backgroundPaint)
            enemySpaceship.draw(canvas)
            spaceship.draw(canvas)
            for (m in lesMissiles){
              m.draw(canvas)
            }

            holder.unlockCanvasAndPost(canvas)

        }
    }
    fun updatePositions(elapsedTimeMS: Double) { //Ceci est la méthode qui change la position des objets, elle se sert de la méthode update() définie differament dans chaque
        val interval = elapsedTimeMS / 1000.0
        enemySpaceship.update(interval)
        spaceship.update(interval)
        for(m in lesMissiles){
            m.update(interval)
        }}

    override fun onTouchEvent(e: MotionEvent): Boolean {

        when (e.action) {
            MotionEvent.ACTION_DOWN -> {
                //val x = e.rawX.toInt() - 100
                //val y = e.rawY.toInt() - 300
                lesMissiles.add(Missile(spaceship.SpaceshipDistance, spaceship.SpaceshipDebut+width/7, spaceship.SpaceshipFin+height/8,this.height/0.5f,10f,this))

            }

        }
        return true
    }
    /*override fun onTouchEvent(e: MotionEvent): Boolean {
        val action = e.action
        if (action == MotionEvent.ACTION_DOWN
            || action == MotionEvent.ACTION_MOVE) {
            tirerMissile(e)
        }
        return true
    }

    fun tirerMissile(event: MotionEvent) {
        var shotsFired =0
        if (! missile.missileOnScreen) {
             val PI: Double = kotlin.math.PI
            val angle = PI


            missile.launch(angle)
            ++shotsFired
        }
    }*/



    override fun surfaceChanged(holder: SurfaceHolder, format: Int,
                                width: Int, height: Int) {}

    override fun surfaceCreated(holder: SurfaceHolder) {}

    override fun surfaceDestroyed(holder: SurfaceHolder) {}





}
