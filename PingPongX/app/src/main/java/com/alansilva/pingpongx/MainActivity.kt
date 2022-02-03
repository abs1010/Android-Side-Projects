package com.alansilva.pingpongx

import android.inputmethodservice.Keyboard
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alansilva.pingpongx.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Score Variables
    private var playerOneScore = 0
    private var playerTwoScore = 0

    private val PLAYER1_SCORE = "KEY_PLAYER1_SCORE"
    private val PLAYER2_SCORE = "KEY_PLAYER2_SCORE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpExtras()

        setUpListeners()

        if(savedInstanceState != null) {
            playerOneScore = savedInstanceState.getInt(PLAYER1_SCORE)
            playerTwoScore = savedInstanceState.getInt(PLAYER2_SCORE)
            setUpScorePlayerOne()
            setUpScorePlayerTwo()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(PLAYER1_SCORE, playerOneScore)
        outState.putInt(PLAYER2_SCORE, playerTwoScore)
    }

    private fun setUpListeners() {

        //Finish Button
        binding.btFinishMatch.setOnClickListener {
            finish()
        }

        //PlayerOne Button
        binding.btPlayerOneScore.setOnClickListener {
            playerOneScore++
            setUpScorePlayerOne()
        }

        //Player Two Button
        binding.btPlayerTwoScore.setOnClickListener {
            playerTwoScore++
            setUpScorePlayerTwo()
        }

        //Revenge Button
        binding.btRevenge.setOnClickListener {
            playerOneScore = 0
            playerTwoScore = 0

            setUpScorePlayerOne()
            setUpScorePlayerTwo()
        }

    }

    private fun setUpScorePlayerOne() {
        binding.tvPlayerOneScore.text = playerOneScore.toString()
    }
    private fun setUpScorePlayerTwo() {
        binding.tvPlayerTwoScore.text = playerTwoScore.toString()
    }

    private fun setUpExtras() {
        binding.tvPlayerOneName.text = intent.getStringExtra(KEY_PLAYER1_EXTRA)
        binding.tvPlayerTwoName.text = intent.getStringExtra(KEY_PLAYER2_EXTRA)
    }

    companion object {
        const val KEY_PLAYER1_EXTRA = "PLAYER1"
        const val KEY_PLAYER2_EXTRA = "PLAYER2"
    }
}