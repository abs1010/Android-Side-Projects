package com.alansilva.placardageral.presentation.game

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alansilva.placardageral.R
import com.alansilva.placardageral.databinding.ActivityGameTypeBinding
import com.alansilva.placardageral.presentation.game.types.BasketScoreActivity
import com.alansilva.placardageral.presentation.game.types.FootballScoreActivity
import com.alansilva.placardageral.presentation.game.types.TrucoScoreActivity

class GameType : AppCompatActivity() {

    private lateinit var binding: ActivityGameTypeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGameTypeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpListeners()

    }

    private fun setUpListeners() {

        binding.btTruco.setOnClickListener {
            val nextScreen = Intent(this, TrucoScoreActivity::class.java)
            //nextScreen.putExtra(MainActivity.KEY_PLAYER1_EXTRA, binding.etPlayer1.text.toString())
            //nextScreen.putExtra(MainActivity.KEY_PLAYER2_EXTRA, binding.etPlayer2.text.toString())
            startActivity(nextScreen)
        }

        binding.btBasket.setOnClickListener {
            val nextScreen = Intent(this, BasketScoreActivity::class.java)
            //nextScreen.putExtra(MainActivity.KEY_PLAYER1_EXTRA, binding.etPlayer1.text.toString())
            //nextScreen.putExtra(MainActivity.KEY_PLAYER2_EXTRA, binding.etPlayer2.text.toString())
            startActivity(nextScreen)
        }

        binding.btSoccer.setOnClickListener {
            val nextScreen = Intent(this, FootballScoreActivity::class.java)
            //nextScreen.putExtra(MainActivity.KEY_PLAYER1_EXTRA, binding.etPlayer1.text.toString())
            //nextScreen.putExtra(MainActivity.KEY_PLAYER2_EXTRA, binding.etPlayer2.text.toString())
            startActivity(nextScreen)
        }

    }
}