package com.alansilva.pingpongx

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var goalHome : MutableLiveData<Int> = MutableLiveData()
    var goalAway : MutableLiveData<Int> = MutableLiveData()

    init {
        startGame()
    }

    fun goalHome() {
        goalHome.value = goalHome.value?.plus(1)
    }

    fun goalAway() {
        goalAway.value = goalAway.value?.plus(1)
    }

    fun restart() {
        startGame()
    }

    private fun startGame() {
        goalHome.value = 0
        goalAway.value = 0
    }

}