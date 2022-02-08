package com.alansilva.lembretedecompras.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alansilva.lembretedecompras.models.RequestState
import com.alansilva.lembretedecompras.models.User

class UserRepository {

    fun login(user: User): LiveData<RequestState<String>> {

        val response = MutableLiveData<RequestState<String>>()

        response.value = RequestState.Loading

        if (user.email == "alan@gmail.com" && user.password == "123456") {
            response.value = RequestState.Success("")
        } else {
            val exeption = Exception("Usuário ou senha inválido")
            response.value = RequestState.Error(exeption)
        }
        return response
    }

}