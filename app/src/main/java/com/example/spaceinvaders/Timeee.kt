package com.example.spaceinvaders

class Timeee (
    var timeLeft : Double = 120.0
) {


    fun reset(){
        timeLeft = 120.0
    }

    fun enleveTemps(){
        timeLeft -=10.0
    }
}