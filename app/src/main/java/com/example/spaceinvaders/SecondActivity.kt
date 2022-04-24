package com.example.spaceinvaders

import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SecondActivity : AppCompatActivity(){
    private var mediaPlayer : MediaPlayer? = null
    lateinit var spaceview: SpaceView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        spaceview = findViewById(R.id.vMain)

        val musicSWITCH = findViewById<Switch>(R.id.switch1)
        val changeActivityBTN = findViewById<FloatingActionButton>(R.id.floatingActionButton2)
        val pauseBTN = findViewById<FloatingActionButton>(R.id.floatingActionButton1)
        val playBTN = findViewById<FloatingActionButton>(R.id.floatingActionButton3)

        musicSWITCH.isChecked=false


        changeActivityBTN.setOnClickListener{
            Toast.makeText(this,"Redémarrage du jeu", Toast.LENGTH_SHORT).show()
            stopAudio()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        pauseBTN.setOnClickListener {
            onPause()
            pauseBTN.hide()
            playBTN.show()

        }
        playBTN.setOnClickListener {
            onResume()
            playBTN.hide()
            pauseBTN.show()

        }

        musicSWITCH.setOnCheckedChangeListener{ _, isChecked ->
            if (isChecked) {
                playAudio()
                Toast.makeText(this,"Musique lancée", Toast.LENGTH_SHORT).show()
            } else {
                pauseAudio()
                Toast.makeText(this,"Musique pausée", Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun onPause() {
        super.onPause()
        spaceview.pause()
    }

    override fun onResume() {
        super.onResume()
        spaceview.resume()
    }
    private fun playAudio() {
        if(mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(this, R.raw.battle_of_the_heroes)
        }
        mediaPlayer?.start()

    }
    private fun pauseAudio() {
        if (mediaPlayer?.isPlaying() == true){
            mediaPlayer?.pause()


        }

    }
    private fun stopAudio(){
        if (mediaPlayer?.isPlaying() == true){
            mediaPlayer?.stop()
            mediaPlayer = null
        }
    }

}