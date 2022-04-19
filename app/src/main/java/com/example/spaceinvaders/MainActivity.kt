package com.example.spaceinvaders


import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri

import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var mediaPlayer : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val musicSWITCH = findViewById<Switch>(R.id.switch2)
        val changeActivityBTN = findViewById<Button>(R.id.button1)

        changeActivityBTN.setOnClickListener{
            stopAudio()
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
        musicSWITCH.setOnCheckedChangeListener{ _, isChecked ->
            if (isChecked) {
                playAudio()
            } else {
                pauseAudio()
            }
        }

    }
    private fun playAudio() {
        if(mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(this, R.raw.cantina_band)
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
