package com.alansilva.pingpongx

import android.content.ActivityNotFoundException
import android.content.Intent
import android.inputmethodservice.Keyboard
import android.net.Uri
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

    companion object {
        const val KEY_PLAYER1_EXTRA = "PLAYER1"
        const val KEY_PLAYER2_EXTRA = "PLAYER2"
    }

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

        binding.btFinishMatch.setOnClickListener {
            val ret = Intent()
            ret.putExtra(KEY_RESULT_EXTRA_PLAYER_ONE_NAME, binding.tvPlayerOneName.text.toString())
            ret.putExtra(KEY_RESULT_EXTRA_PLAYER_TWO_NAME, binding.tvPlayerTwoName.text.toString())
            ret.putExtra(KEY_RESULT_EXTRA_PLAYER_ONE_SCORE, binding.tvPlayerOneScore.text.toString().toInt())
            ret.putExtra(KEY_RESULT_EXTRA_PLAYER_TWO_SCORE, binding.tvPlayerTwoScore.text.toString().toInt())
            setResult(RESULT_OK, ret)
            super.finish()
        }

        binding.btShareWhatsApp?.setOnClickListener {
            shareWhatsApp()
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

    private fun shareWhatsApp() {
        try {
            val whatsAppIntent = Intent(Intent.ACTION_SEND)
            whatsAppIntent.type = "text/plain"
            whatsAppIntent.setPackage("com.whatsapp")
            val message = getString(R.string.message_to_share,
                binding.tvPlayerOneName.text,
                binding.tvPlayerTwoName.text,
                binding.tvPlayerOneScore.text.toString().toInt(),
                binding.tvPlayerTwoScore.text.toString().toInt())
            whatsAppIntent.putExtra(Intent.EXTRA_TEXT, message)
            startActivity(whatsAppIntent)
        } catch (e: ActivityNotFoundException) {
            //Toast.makeText(this, "WhatsApp não instalado", Toast.LENGTH_LONG).show()
            val appPackageName = "com.whatsapp"
            try {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$appPackageName")))
            } catch (anfe: android.content.ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")))
            }
        }
    }

}