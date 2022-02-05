package com.alansilva.placardageral.presentation.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.alansilva.placardageral.R
import com.alansilva.placardageral.databinding.ActivitySplash2Binding
import com.alansilva.placardageral.presentation.player.PlayerActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplash2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplash2Binding.inflate(layoutInflater)

        setContentView(binding.root)

        initAnimation()

        nextScreen()

    }

    private fun nextScreen() {
        Handler(Looper.getMainLooper()).postDelayed({
            val nextScreen = Intent(this, PlayerActivity::class.java)
            startActivity(nextScreen)
            finish()
        }, 1800)
    }

    private fun initAnimation() {
        val anim = AnimationUtils.loadAnimation(this, R.anim.splash)
        binding.ivLogo.startAnimation(anim)
        binding.ivLogoName.startAnimation(anim)
    }
}