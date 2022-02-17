package com.alansilva.jogodavelha.domain.models

data class Cell(var player: Player?) {

    val isEmpty: Boolean
        get() = player?.value?.isEmpty() == true
}