package com.alansilva.lembretedecompras.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alansilva.lembretedecompras.models.RequestState
import com.alansilva.lembretedecompras.models.User
import com.alansilva.lembretedecompras.repository.UserRepository

class LoginViewModel: ViewModel() {

    private val userRepository = UserRepository()

    val loginState = MutableLiveData<RequestState<String>>()

    fun login(user: User) {
        loginState.value = userRepository.login(user).value
    }

}