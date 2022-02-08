package com.alansilva.lembretedecompras.ui.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.alansilva.lembretedecompras.models.RequestState
import com.alansilva.lembretedecompras.models.User
import com.alansilva.lembretedecompras.repository.UserRepository

class LoginViewModel(application: Application): AndroidViewModel(application) {

    private val userRepository = UserRepository(application)

    val loginState = MutableLiveData<RequestState<String>>()

    val loggedUserState = MutableLiveData<RequestState<String>>()

    fun getLoggerUser() {
        loggedUserState.value = userRepository.getLoggedUser().value
    }

    fun login(user: User) {
        loginState.value = userRepository.login(user).value
    }

}