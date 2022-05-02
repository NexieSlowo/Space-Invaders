package com.example.spaceinvaders

interface InterfaceAddTime {
    val hit_reward: Double
        get() = 10.0
    var timeleft: Double
        get() = 0.0
        set(value) = TODO()

    fun addtime(){
        timeleft += hit_reward
    }
}