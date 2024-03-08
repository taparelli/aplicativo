package br.com.fiap.aplicativo.model

import com.google.gson.annotations.SerializedName

data class Endereco (
    val cep: String = "",
    @SerializedName("logradouro") var rua : String = "",
    @SerializedName("localidade") var cidade : String = "",
    var bairro: String = "",
    var uf: String = ""
) : () -> Unit {
    override fun invoke() {
        TODO("Not yet implemented")
    }
}

