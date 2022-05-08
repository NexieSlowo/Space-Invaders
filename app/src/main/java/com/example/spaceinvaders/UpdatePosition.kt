package com.example.spaceinvaders

interface UpdatePosition {
   /* val hit_reward: Double
        get() = 10.0
    var timeleft: Double
        get() = 0.0
        set(value) = TODO()

    fun addtime(){
        timeleft += hit_reward
    }
    fun removetime(){
        timeleft -=  hit_reward
    }*/
   // abstract fun changetime(enemySpaceship: EnemySpaceship)

    abstract fun updatePosition(interval:Double,enemySpaceship:EnemySpaceship,allySpaceship: AllySpaceship,bonus: Bonus,timeee: Timeee)

}