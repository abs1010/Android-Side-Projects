package com.alansilva.placardageral.presentation.game

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    var goalHome : MutableLiveData<Int> = MutableLiveData()
    var goalAway : MutableLiveData<Int> = MutableLiveData()

    init {
        startGame()
    }

    fun goalHome(points: Int = 1) {
        goalHome.value = goalHome.value?.plus(points)
    }

    fun goalAway(points: Int = 1) {
        goalAway.value = goalAway.value?.plus(points)
    }

    fun restart() {
        startGame()
    }

    private fun startGame() {
        goalHome.value = 0
        goalAway.value = 0
    }

}