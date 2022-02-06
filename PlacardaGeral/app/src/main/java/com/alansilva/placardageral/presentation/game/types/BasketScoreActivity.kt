package com.alansilva.placardageral.presentation.game.types

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alansilva.placardageral.databinding.ActivityBasketScoreBinding

class BasketScoreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBasketScoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBasketScoreBinding.inflate(layoutInflater)

        setContentView(binding.root)

    }
}