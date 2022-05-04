package com.alansilva.ondeeh.data.remote

import com.alansilva.ondeeh.domain.model.Endereco
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface EnderecoService {
    @GET("ws/{cep}/json/")
    fun pesquisar(@Path("cep") cep: String): Call<Endereco>
}