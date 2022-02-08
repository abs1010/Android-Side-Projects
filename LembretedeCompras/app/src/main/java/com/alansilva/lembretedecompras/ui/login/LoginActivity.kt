package com.alansilva.lembretedecompras.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.alansilva.lembretedecompras.R
import com.alansilva.lembretedecompras.databinding.ActivityLoginBinding
import com.alansilva.lembretedecompras.models.RequestState
import com.alansilva.lembretedecompras.models.User
import com.alansilva.lembretedecompras.ui.main.MainActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var animationFox: Animation
    private lateinit var animationForm: Animation
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hideKeyboard()
        initAnimation()

        initListener()
        initViewModel()
        initObserver()
    }

    private fun initObserver() {

        loginViewModel.loginState.observe(this,  {

            when (it) {

                is RequestState.Loading -> {
                    Toast.makeText(this, "Estou carregando", Toast.LENGTH_SHORT).show()
                }

                is RequestState.Error -> {
                    val animShake = AnimationUtils.loadAnimation(this, R.anim.shake)
                    binding.containerLogin.startAnimation(animShake)
                    binding.tvPasswordFeedback.text = it.throwable.message
                }

                is RequestState.Success -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }

            }
        })

    }

    private fun initViewModel() {
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    private fun initListener() {

        //Set the observer for the button tap
        binding.btLogin.setOnClickListener {
            loginViewModel.login(
                User(
                    binding.etEmail.text.toString(),
                    binding.etPassword.text.toString()
                )
            ) }


        //Set the observer for focus change of password textField
        binding.etPassword.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                binding.ivLogin.speed = 2f
                binding.ivLogin.setMinAndMaxProgress(0.0f, 0.65f)
            } else {
                binding.ivLogin.speed = 1f
                binding.ivLogin.setMinAndMaxProgress(0.65f, 1.0f)
            }
            binding.ivLogin.playAnimation()
        }

    }

    private fun hideKeyboard() {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }

    private fun initAnimation() {
        animationFox = AnimationUtils.loadAnimation(this, R.anim.frombottom2)
        animationForm = AnimationUtils.loadAnimation(this, R.anim.frombottom)

        binding.ivLogin.clearAnimation()
        binding.containerLogin.clearAnimation()

        binding.ivLogin.startAnimation(animationFox)
        binding.containerLogin.startAnimation(animationForm)
    }
}