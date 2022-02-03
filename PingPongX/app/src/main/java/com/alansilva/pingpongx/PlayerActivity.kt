package com.alansilva.pingpongx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alansilva.pingpongx.databinding.ActivityPlayerBinding

class PlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPlayerBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            val nextScreen = Intent(this, MainActivity::class.java)

            nextScreen.putExtra(MainActivity.KEY_PLAYER1_EXTRA, binding.etPlayer1.text.toString())
            nextScreen.putExtra(MainActivity.KEY_PLAYER2_EXTRA, binding.etPlayer2.text.toString())

            startActivity(nextScreen)
        }

    }

}