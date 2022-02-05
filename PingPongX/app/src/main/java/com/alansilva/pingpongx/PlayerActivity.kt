package com.alansilva.pingpongx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.alansilva.pingpongx.databinding.ActivityPlayerBinding

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
            val nextScreen = Intent(this, MainActivity::class.java)

            nextScreen.putExtra(MainActivity.KEY_PLAYER1_EXTRA, binding.etPlayer1.text.toString())
            nextScreen.putExtra(MainActivity.KEY_PLAYER2_EXTRA, binding.etPlayer2.text.toString())

            //startActivity(nextScreen)
            previewRequest.launch(nextScreen)

        }

    }

    private val previewRequest =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val lastResult = getString(R.string.message_to_share,
                    it.data?.getStringExtra(KEY_RESULT_EXTRA_PLAYER_ONE_NAME),
                    it.data?.getStringExtra(KEY_RESULT_EXTRA_PLAYER_TWO_NAME),
                    it.data?.getIntExtra(KEY_RESULT_EXTRA_PLAYER_ONE_SCORE, 0),
                    it.data?.getIntExtra(KEY_RESULT_EXTRA_PLAYER_TWO_SCORE, 0))
                binding.tvLastGame.text = lastResult
            }
        }

}