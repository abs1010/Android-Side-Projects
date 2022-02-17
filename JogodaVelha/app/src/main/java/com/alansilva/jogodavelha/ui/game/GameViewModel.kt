package com.alansilva.jogodavelha.ui.game

import androidx.databinding.ObservableArrayMap
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.alansilva.jogodavelha.domain.models.Cell
import com.alansilva.jogodavelha.domain.models.Game
import com.alansilva.jogodavelha.domain.models.Player

class GameViewModel : ViewModel() {

    lateinit var cells: ObservableArrayMap<String, String>
    private lateinit var game: Game

    val winner: LiveData<Player>
        get() = game.winner

    fun init(player1: String, player2: String) {
        game = Game(player1, player2)
        cells = ObservableArrayMap()
    }

    fun onClickedCellAt(row: Int, column: Int) {
        if (game.cells[row][column] == null) {
            game.cells[row][column] = Cell(game.currentPlayer)
            cells["$row$column"] = game.currentPlayer?.value
            if (game.hasGameEnded())
                game.reset()
            else
                game.switchPlayer()
        }
    }
}