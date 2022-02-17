package com.alansilva.jogodavelha.domain.models

import org.junit.Assert.*
import org.junit.Test

class GameTest {

    @Test
    fun returnTrueIfHasThreeSameHorizontalCellAtRow1() {
        //Cenario
        val game = Game("Android", "iOS")
        val player = game.player1
        val cell = Cell(player)
        game.cells[0][0] = cell
        game.cells[0][1] = cell
        game.cells[0][2] = cell
        //Ação
        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()
        //Resultado
        assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    fun returnTrueIfHasThreeSameHorizontalCellAtRow2() {
        //Cenario
        val game = Game("Android", "iOS")
        val player = game.player1
        val cell = Cell(player)
        game.cells[1][0] = cell
        game.cells[1][1] = cell
        game.cells[1][2] = cell
        //Ação
        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()
        //Resultado
        assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    fun returnTrueIfHasThreeSameHorizontalCellAtRow3() {
        //Cenario
        val game = Game("Android", "iOS")
        val player = game.player1
        val cell = Cell(player)
        game.cells[2][0] = cell
        game.cells[2][1] = cell
        game.cells[2][2] = cell
        //Ação
        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()
        //Resultado
        assertTrue(hasThreeSameHorizontalCells)
    }

}