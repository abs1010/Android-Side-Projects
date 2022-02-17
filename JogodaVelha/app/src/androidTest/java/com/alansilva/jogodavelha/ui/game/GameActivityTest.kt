package com.alansilva.jogodavelha.ui.game

import androidx.test.rule.ActivityTestRule
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.adevinta.android.barista.interaction.BaristaClickInteractions.clickOn
import com.adevinta.android.barista.interaction.BaristaDialogInteractions.clickDialogPositiveButton
import com.adevinta.android.barista.interaction.BaristaEditTextInteractions.writeTo
import com.alansilva.jogodavelha.R
import com.alansilva.jogodavelha.domain.models.Player
import org.junit.Rule
import org.junit.Test

class GameActivityTest {
    @Rule
    @JvmField

    var activityRule: ActivityTestRule<GameActivity> = ActivityTestRule(GameActivity::class.java)
    private val player1 = Player("Heider", "x")
    private val player2 = Player("Android", "o")

    @Test
    fun end_game_when_one_player_wins() {
        writeTo(R.id.et_player1, player1.name)
        writeTo(R.id.et_player2, player2.name)
        clickDialogPositiveButton()
        clickOn(R.id.cell_00)
        clickOn(R.id.cell_10)
        clickOn(R.id.cell_01)
        clickOn(R.id.cell_11)
        clickOn(R.id.cell_02)
        assertDisplayed(R.id.tvWinner)
        assertDisplayed(player1.name)
    }

}