package com.example.spaceinvaders

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SecondActivity : AppCompatActivity() {
    private var mediaPlayer : MediaPlayer? = null
    lateinit var spaceview: SpaceView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        spaceview = findViewById(R.id.vMain)

        val musicSWITCH = findViewById<Switch>(R.id.switch1)
        val changeActivityBTN = findViewById<FloatingActionButton>(R.id.floatingActionButton2)
        val pauseBTN = findViewById<FloatingActionButton>(R.id.floatingActionButton1)

        changeActivityBTN.setOnClickListener{
            stopAudio()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        pauseBTN.setOnClickListener {
            pauseAudio()
            musicSWITCH.isChecked=false
        }

        musicSWITCH.setOnCheckedChangeListener{ _, isChecked ->
            if (isChecked) {
                playAudio()
            } else {
                pauseAudio()
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
        Toast.makeText(this,"Music started", Toast.LENGTH_SHORT).show()
    }
    private fun pauseAudio() {
        if (mediaPlayer?.isPlaying() == true){
            mediaPlayer?.pause()

            Toast.makeText(this,"Music paused", Toast.LENGTH_SHORT).show()
        }

    }
    private fun stopAudio(){
        if (mediaPlayer?.isPlaying() == true){
            mediaPlayer?.stop()
            mediaPlayer = null
            Toast.makeText(this,"Music stopped", Toast.LENGTH_SHORT).show()
        }
    }
}