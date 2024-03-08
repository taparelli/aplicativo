package br.com.fiap.aplicativo.service

import br.com.fiap.aplicativo.model.Endereco
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EnderecoService {
    @GET("{cep}/json/")
    fun getEnderecobyCep(@Path("cep") cep: String): Call<Endereco>
}