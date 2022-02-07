package com.alansilva.placardageral.presentation.game.types

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.alansilva.placardageral.R
import com.alansilva.placardageral.databinding.ActivityTrucoScoreBinding
import com.alansilva.placardageral.presentation.game.GameViewModel

class TrucoScoreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrucoScoreBinding
    private lateinit var vewModel: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpBinding()
        setUpListeners()
        //initObserver()

    }

    private fun setUpBinding() {
        binding = ActivityTrucoScoreBinding .inflate(layoutInflater)
        setContentView(binding.root)
    }

    // SETUP OBSERVERS
    private fun initObserver() {

        vewModel.goalHome.observe(this, Observer { goalHome ->
            binding.playerOnePlacar.text = "$goalHome"
        })

        vewModel.goalAway.observe(this, Observer {
            binding.playerTwoPlacar.text = "$it"
        })

    }

    // SETUP LISTENERS
    private fun setUpListeners() {

        //Home -1
        binding.btPOneMinus1.setOnClickListener {
            vewModel.goalHome(-1)
        }

        //Home 1
        binding.btPOnePlus1.setOnClickListener {
            vewModel.goalHome()
        }

        //Home 3
        binding.btPOnePlus3.setOnClickListener {
            vewModel.goalHome(3)
        }

        //Home 6
        binding.btPOnePlus6.setOnClickListener {
            vewModel.goalHome(6)
        }

        //Home 9
        binding.btPOnePlus9.setOnClickListener {
            vewModel.goalHome(9)
        }

        //Home 12
        binding.btPOnePlus12.setOnClickListener {
            vewModel.goalHome(12)
        }

        //Home -1
        binding.btPTwoMinus1.setOnClickListener {
            vewModel.goalAway(-1)
        }

        //Home 1
        binding.btPTwoPlus1.setOnClickListener {
            vewModel.goalAway()
        }

        //Home 3
        binding.btPTwoPlus3.setOnClickListener {
            vewModel.goalAway(3)
        }

        //Home 6
        binding.btPTwoPlus6.setOnClickListener {
            vewModel.goalAway(6)
        }

        //Home 9
        binding.btPTwoPlus9.setOnClickListener {
            vewModel.goalAway(9)
        }

        //Home 12
        binding.btPTwoPlus12.setOnClickListener {
            vewModel.goalAway(12)
        }

        //WhatsApp Button ----
        binding.btShareWhatsApp.setOnClickListener {
            shareWhatsApp()
        }

        //Finish Button
        binding.btFinishMatch.setOnClickListener {
            vewModel.restart()
        }

        //Revenge Button
        binding.btRevenge.setOnClickListener {
            vewModel.restart()
        }

    }

    // CALL WHATSAPP APPLICATION
    private fun shareWhatsApp() {

    }

}