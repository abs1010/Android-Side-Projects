package com.alansilva.placardageral.presentation.player

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alansilva.placardageral.R
import com.alansilva.placardageral.databinding.ActivityPlayerBinding
import com.alansilva.placardageral.presentation.game.GameType

class PlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPlayerBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setUpListener()

    }

    private fun setUpListener() {

        binding.btnStart.setOnClickListener {
            val nextScreen = Intent(this, GameType::class.java)

            //nextScreen.putExtra(MainActivity.KEY_PLAYER1_EXTRA, binding.etPlayer1.text.toString())
            //nextScreen.putExtra(MainActivity.KEY_PLAYER2_EXTRA, binding.etPlayer2.text.toString())

            startActivity(nextScreen)
        }

    }

}