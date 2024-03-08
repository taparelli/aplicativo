package br.com.fiap.aplicativo.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitFactory {
    private val URl =  "https://viacep.com.br/ws/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getCepService(): EnderecoService {
        return retrofitFactory.create(EnderecoService::class.java)
    }
}