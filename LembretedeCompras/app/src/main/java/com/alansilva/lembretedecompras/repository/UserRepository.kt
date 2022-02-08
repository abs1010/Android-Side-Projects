package com.alansilva.lembretedecompras.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alansilva.lembretedecompras.models.RequestState
import com.alansilva.lembretedecompras.models.User

class UserRepository(val context: Context) {

    fun login(user: User): LiveData<RequestState<String>> {

        val response = MutableLiveData<RequestState<String>>()

        response.value = RequestState.Loading

        if (user.email == "alan@gmail.com" && user.password == "123456") {

            val pref = context.getSharedPreferences("lembretedecompras", Context.MODE_PRIVATE)

            val editor = pref.edit()
            editor.putString("email", user.email)
            //editor.putBoolean("professor", true)
            editor.apply()

            response.value = RequestState.Success("")
        } else {
            val exeption = Exception("Usuário ou senha inválido")
            response.value = RequestState.Error(exeption)
        }
        return response
    }

    fun getLoggedUser() : LiveData<RequestState<String>> {

        val response = MutableLiveData<RequestState<String>>()

        val pref = context.getSharedPreferences("lembretedecompras", Context.MODE_PRIVATE)
        val email = pref.getString("email", "") ?: ""

        response.value = RequestState.Success(email)

        return response

    }

}