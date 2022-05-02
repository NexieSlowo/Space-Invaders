package com.example.spaceinvaders




import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.Button
import java.util.*
import kotlin.random.Random


class SpaceView @JvmOverloads constructor(
    context      : Context,
    attributes   : AttributeSet? = null,
    defStyleAttr : Int           = 0):

    SurfaceView(
        context,
        attributes,
        defStyleAttr),

    SurfaceHolder.Callback,
    Runnable {

    lateinit var canvas    : Canvas
    val backgroundPaint    = Paint()
    var screenWidth        = 0f
    var screenHeight       = 0f
    var drawing            = false
    var timeLeft           = 0.0
    val textPaint          = Paint()
    lateinit var thread    : Thread
    var randomTimer:Double = 0.0
    var randomTimer2:Double = 0.0

    val enemySpaceship = EnemySpaceship(view=this, context = this)
    val allySpaceship  = AllySpaceship (view=this, context = this)
    val etoile1        = etoile (view=this, context = this)
    val etoile2        = etoile (view=this, context = this)
    val etoile3        = etoile (view=this, context = this)
    val etoile4        = etoile (view=this, context = this)
    val etoile5        = etoile (view=this, context = this)
    val etoile6        = etoile (view=this, context = this)
    val bonus          = Bonus (view=this,context= this)

    val lesMissilesAlly = arrayListOf<MissileAlly>()
    val lesMissilesEnemy = arrayListOf<MissileEnemy>()
    val lesMissilesJaunes = arrayListOf<MissileJaune>()
    val imageBackground = BitmapFactory.decodeResource(context.resources, R.drawable.gradient)

    init{
        backgroundPaint.color = Color.WHITE     // Création du background
        textPaint.textSize    = screenWidth/20  // timer taille
        textPaint.color       = Color.WHITE     // timer couleur
        timeLeft              = 120.0}          // timer temps restant



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

        enemySpaceship.SpaceshipDistance = (w/3f)
        enemySpaceship.SpaceshipDebut = (0.3f*h)
        enemySpaceship.SpaceshipFin = (0.3f*h)
        enemySpaceship.setRect()

        allySpaceship.SpaceshipDistance = (w/5f)
        allySpaceship.SpaceshipDebut = (9999*h/10000f-200)
        allySpaceship.SpaceshipFin = (9999*h/10000f-200)
        allySpaceship.setRect()


        /*missile.missileDistance = (w/6f)
        missile.initialMissileVitesse = (1000f)
        missile.missileDebut = (h / 2f)
        missile.missileFin = (h  / 0.5f)
        missile.width= (w / 15f)
        missile.setRect()*/
        textPaint.setTextSize(50f)
        textPaint.isAntiAlias = true

        etoile1.EtoileDistance = (5*w/10000f)
        etoile1.EtoileDebut = (2400*h/10000f)
        etoile1.EtoileFin = etoile1.EtoileDebut
        etoile1.setRect()

        etoile2.EtoileDistance = (1200*w/10000f)
        etoile2.EtoileDebut = etoile1.EtoileDebut
        etoile2.EtoileFin = etoile1.EtoileDebut
        etoile2.setRect()

        etoile3.EtoileDistance = (2400*w/10000f)
        etoile3.EtoileDebut = etoile1.EtoileDebut
        etoile3.EtoileDebut = etoile1.EtoileDebut
        etoile3.setRect()

        etoile4.EtoileDistance = etoile1.EtoileDistance
        etoile4.EtoileDebut = (10900*h/10000f)
        etoile4.EtoileFin = etoile4.EtoileDebut
        etoile4.setRect()

        etoile5.EtoileDistance = etoile2.EtoileDistance
        etoile5.EtoileDebut = etoile4.EtoileDebut
        etoile5.EtoileFin = etoile4.EtoileDebut
        etoile5.setRect()

        etoile6.EtoileDistance = etoile3.EtoileDistance
        etoile6.EtoileDebut = etoile4.EtoileDebut
        etoile6.EtoileFin = etoile4.EtoileDebut
        etoile6.setRect()

        bonus.Distance = (1*w/2f)
        bonus.Debut = (4*h/8f)
        bonus.Fin = bonus.Debut
        bonus.setRect()

    }
    fun draw() { //Ceci fait le déssin final, il se sert de draw() définis dans  enemySpaceship et Spacheship
        if (holder.surface.isValid) {
            canvas = holder.lockCanvas()
            canvas.drawBitmap(imageBackground,0f,0f, null)
            enemySpaceship.draw(canvas)
            allySpaceship.draw(canvas)
            bonus.draw(canvas)

            when (enemySpaceship.vie){
                3 -> {
                    etoile1.draw(canvas)
                    etoile2.draw(canvas)
                    etoile3.draw(canvas)}
                2 -> {
                    etoile1.draw(canvas)
                    etoile2.draw(canvas)}
                1 -> {
                    etoile1.draw(canvas)}}

            when(allySpaceship.vie){
                3 -> {
                    etoile4.draw(canvas)
                    etoile5.draw(canvas)
                    etoile6.draw(canvas)}
                2 -> {
                    etoile4.draw(canvas)
                    etoile5.draw(canvas)}
                1 -> {
                    etoile4.draw(canvas)}}


            canvas.drawText("Il reste ${String.format("%.2f", timeLeft)} s", 50f, 40f, textPaint)

            for (m in lesMissilesAlly){
              m.draw(canvas)
            }
            for(j in lesMissilesEnemy){
                j.draw(canvas)
            }

            for(k in lesMissilesJaunes){
                k.draw(canvas)
            }




            holder.unlockCanvasAndPost(canvas)


    }}
    fun updatePositions(elapsedTimeMS: Double) { //Ceci est la méthode qui change la position des objets, elle se sert de la méthode update() définie differament dans chaque
        val interval = elapsedTimeMS / 1000.0
        enemySpaceship.update(interval)
        allySpaceship.update(interval)
        //
        //Mettre le if missileonScreen pour les missiles de la liste
            for(m in lesMissilesAlly){
                m.update(interval,enemySpaceship,allySpaceship) }

            for( j in lesMissilesEnemy){
                j.update(interval,enemySpaceship,allySpaceship)
        }
        for( k in lesMissilesJaunes){
            k.update(interval,enemySpaceship,allySpaceship)}


        timeLeft -= interval
        randomTimer -= interval
        randomTimer2 -= interval
        if (timeLeft/60 <= 0.0) drawing = false

        if(randomTimer<=0.0) {
            lesMissilesEnemy.add(MissileEnemy(enemySpaceship.SpaceshipDistance,enemySpaceship.SpaceshipDebut,enemySpaceship.SpaceshipDebut + width/7f,height/2f,10f,this))
            lesMissilesJaunes.add(MissileJaune(enemySpaceship.SpaceshipDistance,enemySpaceship.SpaceshipDebut,enemySpaceship.SpaceshipDebut + width/8f,height/2f,10f,this))

            randomTimer = (Random.nextInt(2,5)).toDouble()
        }

        if(randomTimer2<=0.0) {

            bonus.shining()
            randomTimer2 = (Random.nextInt(1,3)).toDouble()

        }
    }
    fun updateAllySpaceshipPosition(elapsedTimeMS: Double){
        val interval = elapsedTimeMS / 1000.0
        allySpaceship.update(interval)
    }



    override fun onTouchEvent(e: MotionEvent): Boolean {

        when (e.action) {
            MotionEvent.ACTION_DOWN -> {
                //val x = e.rawX.toInt() - 100
                //val y = e.rawY.toInt() - 300
                lesMissilesAlly.add(MissileAlly(allySpaceship.SpaceshipDistance+allySpaceship.width/2, allySpaceship.SpaceshipDebut-14*height/60, allySpaceship.SpaceshipFin-10*height/60,this.height/1.5f,10f,this))
                //lesMissilesEnemy.add(Missile(enemySpaceship.enemySpaceshipDistance,enemySpaceship.enemySpaceshipDebut,enemySpaceship.enemySpaceshipDebut + width/7f,height/0.45f,10f,this))
                allySpaceship.changeVitesse()
            }

        }



        return true
    }







    override fun surfaceChanged(holder: SurfaceHolder, format: Int,
                                width: Int, height: Int) {}

    override fun surfaceCreated(holder: SurfaceHolder) {}

    override fun surfaceDestroyed(holder: SurfaceHolder) {}

    fun pause() { //Ceci arrete l'appli quand on fait pause ou quand on sort de l'appli
        drawing = false
        thread.join()
    }

    fun resume() { //Ceci relance l'appli là où on a laissé quand on est partis
        drawing = true
        thread = Thread(this)
        thread.start()
    }



}
