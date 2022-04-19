package com.example.spaceinvaders

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SecondActivity : AppCompatActivity() {

    lateinit var spaceview: SpaceView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        spaceview = findViewById(R.id.vMain)

        val changeActivityBTN = findViewById<FloatingActionButton>(R.id.floatingActionButton2)
        changeActivityBTN.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
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
}