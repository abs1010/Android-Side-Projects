package com.alansilva.placardageral

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import com.alansilva.placardageral.databinding.ActivitySplash2Binding

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
        }, 2000)
    }

    private fun initAnimation() {
        val anim = AnimationUtils.loadAnimation(this, R.anim.splash)
        binding.ivLogo.startAnimation(anim)
        binding.ivLogoName.startAnimation(anim)
    }
}