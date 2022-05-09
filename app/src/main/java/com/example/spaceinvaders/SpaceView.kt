package com.example.spaceinvaders




import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.*
import android.os.Bundle
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
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
    val textPaint          = Paint()
    lateinit var thread    : Thread
    var randomTimer:Double = 0.0
    var randomTimer2:Double = 0.0
    var restrictedShot = true
    var timer3 : Double = 0.0

    val activity = context as FragmentActivity
    val enemySpaceship = EnemySpaceship(view=this, context = this)
    val allySpaceship  = AllySpaceship (view=this, context = this)

    val obstacle          = Obstacle (view=this,context= this)
    var timeee         = Timeee ()
    var timeOriginal = timeee.timeLeft
    var gameOver       = false
    var shotsFired = 0
    var totalElapsedTime = 0.0
    val lesMissilesAlly   = arrayListOf<MissileAlly>()
    var tourMissile = 0


    private val imageBackground   = BitmapFactory.decodeResource(context.resources, R.drawable.gradient)


    init{
        backgroundPaint.color = Color.WHITE     // Création du background
        textPaint.textSize    = screenWidth/20  // timer taille
        textPaint.color       = Color.WHITE}    // timer couleur




    override fun run() {
        /*Cette fonction met en ouvre le thread, qui fait le mouvement des objets.
        Elle existe déjà donc on le modifie avec override.*/

        var previousFrameTime = System.currentTimeMillis()
        while (drawing) {
            val currentTime = System.currentTimeMillis()
            val elapsedTimeMS = (currentTime-previousFrameTime).toDouble()
            totalElapsedTime += elapsedTimeMS / 1000.0
            updatePositions(elapsedTimeMS) //Méthode définie plus bas qui fait le changement de la position des objets.
            draw()
            previousFrameTime = currentTime
        }
    }
    override fun onSizeChanged(
        w:Int,
        h:Int,
        oldw:Int,
        oldh:Int) {
        /*Cette méthode sert juste pour le moment où on change de mode d'écran , par exemple quand on met en landscape, pour que les dimensions des objets s'addaptent aux nouvelles dimensions*/
        super.onSizeChanged(w, h, oldw, oldh)
        screenWidth                      = w.toFloat()
        screenHeight                     = h.toFloat()

        enemySpaceship.reset()
        allySpaceship.reset()

        textPaint.setTextSize(50f)
        textPaint.isAntiAlias            = true



        obstacle.reset()

        /*missile.missileDistance = (w/6f)
        missile.initialMissileVitesse = (1000f)
        missile.missileDebut = (h / 2f)
        missile.missileFin = (h  / 0.5f)
        missile.width= (w / 15f)
        missile.setRect()*/
    }
    fun draw() { //Ceci fait le déssin final, il se sert de draw() définis dans  enemySpaceship et Spacheship

        if (holder.surface.isValid) {

            canvas = holder.lockCanvas()
            canvas.drawBitmap(imageBackground,0f,0f, null)
            allySpaceship.draw(canvas)
            obstacle.draw(canvas)
            enemySpaceship.draw(canvas)






            canvas.drawText("Temps restant ${(timeee.timeLeft/60).toInt()}:${(timeee.timeLeft%60).toInt()}", 10f, 70f, textPaint)


            /*for(j in lesMissilesRouges){
                j.draw(canvas)
            }
            //for(k in lesMissilesJaunes){
                //k.draw(canvas)
            //}*/
            holder.unlockCanvasAndPost(canvas)
        }
    }


    fun updatePositions(elapsedTimeMS: Double) {
        /*Ceci est la méthode qui change la position des objets,
        elle se sert de la méthode update() définie differament dans chaque*/

        val interval = elapsedTimeMS / 1000.0
        //enemySpaceship.update(interval)
        //allySpaceship.update(interval)
        enemySpaceship.updatePosition(interval,enemySpaceship,allySpaceship,obstacle,timeee)
        allySpaceship.updatePosition(interval,enemySpaceship,allySpaceship,obstacle,timeee)

        //Mettre le if missileonScreen pour les missiles de la liste
            for(m in lesMissilesAlly){
                m.updatePosition(interval,enemySpaceship,allySpaceship,obstacle,timeee)}

            //for( j in lesMissilesRouges){
                //j.update(interval,enemySpaceship,allySpaceship,bonus,timeee)}

        //for( k in lesMissilesJaunes){
            //k.update(interval,enemySpaceship,allySpaceship,bonus,timeee)}


        timeee.timeLeft -= interval
        randomTimer -= interval
        randomTimer2 -= interval
        timer3 -= interval

        if (timeee.timeLeft/60 <= 0.0) drawing = false

        if(randomTimer2<=0.0) {


            obstacle.randomAppearance()
            obstacle.shining()                                     //bonus apparait ou disparait

            if(obstacle.OnScreen){
                val random = Random.nextInt(3,5)     //reste "apparu" entre 3 et 5 s
                randomTimer2 = random.toDouble()
            }
            else{
                val random = Random.nextInt(5,10)   //reste "inapparu" entre 5 et 10 s
                randomTimer2 = random.toDouble()
            }
        }

        if(randomTimer<=0.0){
            when(tourMissile){
                0->{enemySpaceship.createMissileYellow()}
                1->{enemySpaceship.createMissileRed()}
                2->{enemySpaceship.createMissileGreen()}
            }
            tourMissile = Random.nextInt(0,3)
            randomTimer = Random.nextDouble(1.0,3.0)
        }
        if(timeee.timeLeft <= 0.0){
            timeee.timeLeft = 0.0
            gameOver(R.string.lose)
        }
    }







    override fun onTouchEvent(e: MotionEvent): Boolean {
        if(restrictedShot){
            when (e.action) {
                MotionEvent.ACTION_DOWN -> {
                    if(timer3<=0.0) {
                        //val x = e.rawX.toInt() - 100
                        //val y = e.rawY.toInt() - 300
                        allySpaceship.createMissileAlly()
                        //lesMissilesEnemy.add(Missile(enemySpaceship.enemySpaceshipDistance,enemySpaceship.enemySpaceshipDebut,enemySpaceship.enemySpaceshipDebut + width/7f,height/0.45f,10f,this))
                        allySpaceship.changeDirection()
                        ++shotsFired
                        timer3 = 1.0
                    }
                }
            }
        }
        else{
            when (e.action) {
                MotionEvent.ACTION_DOWN -> {
                    //val x = e.rawX.toInt() - 100
                    //val y = e.rawY.toInt() - 300
                    allySpaceship.createMissileAlly()
                    //lesMissilesEnemy.add(Missile(enemySpaceship.enemySpaceshipDistance,enemySpaceship.enemySpaceshipDebut,enemySpaceship.enemySpaceshipDebut + width/7f,height/0.45f,10f,this))
                    allySpaceship.changeDirection()
                    ++shotsFired
                }
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


    fun newGame(){
        allySpaceship.reset()
        enemySpaceship.reset()
        timeee.reset()
        shotsFired = 0
        for (m in lesMissilesAlly){
            m.reset()
        }
        /*for (m in lesMissilesRouges){
            m.reset()
        }
        for (m in lesMissilesJaunes){
            m.reset()
        }*/
        if (gameOver){
            gameOver = false
            run()
            resume()
        }

    }
    fun gameOver(titreDialog: Int){
        for (m in lesMissilesAlly){
            m.reset()
        }
        /*for (m in lesMissilesRouges){
           m.reset()
       }
       for (m in lesMissilesJaunes){
           m.reset()
       }*/
        enemySpaceship.resetMissile()


        drawing=false

        showGameOverDialog(titreDialog)
        gameOver = true
    }

    fun showGameOverDialog(messageId: Int) {
        class GameResult: DialogFragment() {
            override fun onCreateDialog(bundle: Bundle?): Dialog {
                val builder = AlertDialog.Builder(getActivity())
                builder.setTitle(resources.getString(messageId))
                builder.setMessage(
                    resources.getString(
                        R.string.results_format
                    ) + shotsFired
                )
                builder.setPositiveButton(R.string.reset_game,
                    DialogInterface.OnClickListener { _, _->newGame()}
                )
                return builder.create()
            }
        }

        activity.runOnUiThread(
            Runnable {
                val ft = activity.supportFragmentManager.beginTransaction()
                val prev =
                    activity.supportFragmentManager.findFragmentByTag("dialog")
                if (prev != null) {
                    ft.remove(prev)
                }
                ft.addToBackStack(null)
                val gameResult = GameResult()
                gameResult.setCancelable(false)
                gameResult.show(ft,"dialog")
            }
        )
    }

}
