package com.alansilva.placardageral.presentation.game.types

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alansilva.placardageral.R
import com.alansilva.placardageral.databinding.ActivityBasketScoreBinding
import com.alansilva.placardageral.presentation.game.GameViewModel

class BasketScoreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBasketScoreBinding
    private lateinit var vewModel: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpBinding()
        setUpListeners()
        initViewModel()
        initObserver()
    }

    private fun setUpBinding() {
        binding = ActivityBasketScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    // SETUP OBSERVERS
    private fun initObserver() {

        vewModel.goalHome.observe(this, Observer { goalHome ->
            binding.tvPlayerOneScore.text = "$goalHome"
        })

        vewModel.goalAway.observe(this, Observer {
            binding.tvPlayerTwoScore.text = "$it"
        })

    }

    // INIT VIEW MODEL
    private fun initViewModel() {
        vewModel = ViewModelProvider(this).get(GameViewModel::class.java)
    }

    // SETUP LISTENERS
    private fun setUpListeners() {

        //WhatsApp Button
        binding.btShareWhatsApp.setOnClickListener {
            shareWhatsApp()
        }

        //Finish Button
        binding.btFinishMatch.setOnClickListener {
            vewModel.restart()
            finish()
        }

        //PlayerOne Button 1 Point
        binding.btPlayerOneScore1pt.setOnClickListener {
            vewModel.goalHome()
        }

        //PlayerOne Button 3 Points
        binding.btPlayerOneScore3bt.setOnClickListener {
            vewModel.goalHome(3)
        }

        //Player Two Button 1 Point
        binding.btPlayerTwoScore1pt.setOnClickListener {
            vewModel.goalAway()
        }

        //Player Two Button 3 Points
        binding.btPlayerTwoScore3pt.setOnClickListener {
            vewModel.goalAway(3)
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
            val message = getString(
                R.string.message_to_share,
                binding.tvPlayerOneName.text,
                binding.tvPlayerTwoName.text,
                binding.tvPlayerOneScore.text.toString().toInt(),
                binding.tvPlayerTwoScore.text.toString().toInt()
            )
            whatsAppIntent.putExtra(Intent.EXTRA_TEXT, message)
            startActivity(whatsAppIntent)
        } catch (e: ActivityNotFoundException) {
            val appPackageName = "com.whatsapp"
            try {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("market://details?id=$appPackageName")
                    )
                )
            } catch (anfe: android.content.ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")
                    )
                )
            }
        }
    }

}