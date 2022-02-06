package com.alansilva.placardageral.presentation.game.types

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alansilva.placardageral.databinding.ActivityFootballScoreBinding
import com.alansilva.placardageral.presentation.game.GameViewModel
import androidx.lifecycle.Observer

class FootballScoreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFootballScoreBinding
    private lateinit var vewModel: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpBinding()

        setUpListeners()

    }

    private fun setUpBinding() {
        binding = ActivityFootballScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    // SETUP LISTENERS
    private fun setUpListeners() {

        //WhatsApp Button
        binding.btShareWhatsApp?.setOnClickListener {
            shareWhatsApp()
        }

        //Finish Button
        binding.btFinishMatch.setOnClickListener {
            vewModel.restart()
        }

        //PlayerOne Button
        binding.btPlayerOneScore.setOnClickListener {
            vewModel.goalHome()
        }

        //Player Two Button
        binding.btPlayerTwoScore.setOnClickListener {
            vewModel.goalAway()
        }

        //Revenge Button
        binding.btRevenge.setOnClickListener {
            vewModel.restart()
        }

    }

    // CALL WHATSAPP APPLICATION
    private fun shareWhatsApp() {
        try {
            val whatsAppIntent = Intent(Intent.ACTION_SEND)
            whatsAppIntent.type = "text/plain"
            whatsAppIntent.setPackage("com.whatsapp")
            val message = getString(1,
                binding.tvPlayerOneName.text,
                binding.tvPlayerTwoName.text,
                binding.tvPlayerOneScore.text.toString().toInt(),
                binding.tvPlayerTwoScore.text.toString().toInt())
            whatsAppIntent.putExtra(Intent.EXTRA_TEXT, message)
            startActivity(whatsAppIntent)
        } catch (e: ActivityNotFoundException) {
            val appPackageName = "com.whatsapp"
            try {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$appPackageName")))
            } catch (anfe: android.content.ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")))
            }
        }
    }
}