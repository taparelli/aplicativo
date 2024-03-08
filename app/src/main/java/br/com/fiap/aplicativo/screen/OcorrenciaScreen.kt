package br.com.fiap.aplicativo.screen

import android.util.Log
import androidx.compose.foundation.Image

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.aplicativo.R
import br.com.fiap.aplicativo.model.Endereco
import br.com.fiap.aplicativo.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun OcorrenciaScreen(
    navController: NavController,
    tipoOcorrencia: String
) {
    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.Backgroud))
            .fillMaxSize(),
    ) {

        var enderecoList by remember {
            mutableStateOf(listOf(Endereco()))
        }

        var cep by remember {
            mutableStateOf("")
        }

        var numero by remember {
            mutableStateOf("")
        }

        var agressor by remember {
            mutableStateOf("")
        }

        var desaparecido by remember {
            mutableStateOf("")
        }

        var roubo by remember {
            mutableStateOf("")
        }

        var escola by remember {
            mutableStateOf("")
        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.Backgroud))
        ) {
            // ---- header ---------
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(colorResource(id = R.color.menu))
                    .padding(10.dp, 10.dp)
            ) {
                Text(
                    text = "Registro de ocorrência de ${
                        if (tipoOcorrencia == "violencia") {
                            "Violência Familiar"
                        } else if (tipoOcorrencia == "desaparecimento") {
                            "Desaparecimento"
                        } else if (tipoOcorrencia == "roubo") {
                            "Furto/Roubo"
                        } else {
                            "Segurança Escolar"
                        }
                    }",
                    fontSize = 17.sp,
                    color = colorResource(id = R.color.white),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                )
            }

            Row(
                modifier =
                Modifier.fillMaxWidth().padding(top = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,

                ) {

                TextField(
                    value = cep,
                    onValueChange = {
                        cep = it

                    },
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(top = 20.dp),
                    label = {
                        Text(text = "Cep")
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Button(
                    enabled = cep.length == 8,
                    onClick = {
                        var call = RetrofitFactory().getCepService().getEnderecobyCep(cep)
                        call.enqueue(object : Callback<Endereco> {
                            override fun onResponse(
                                call: Call<Endereco>,
                                response: Response<Endereco>
                            ) {
                                enderecoList = arrayOf(response.body()!!).toList()
                                Log.i("FIAP", "${response.body()}")
                            }

                            override fun onFailure(call: Call<Endereco>, t: Throwable) {
                                Log.i("FIAP", "${t.message}")
                            }
                        })
                    }


                ) {
                    Text(text = "buscar")
                }

            }

            TextField(
                value = if (enderecoList[0].rua.isEmpty()) {
                    ""
                } else {
                    enderecoList[0].rua
                },
                onValueChange = {
                    enderecoList[0].rua = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(5.dp, top = 20.dp),
                label = {
                    Text(text = "Rua")
                },

                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            TextField(
                value = numero,
                onValueChange = { letra ->
                    numero = letra

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(5.dp, top = 20.dp),
                label = {
                    Text(text = "Numero")
                },

                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            TextField(
                value = if (enderecoList[0].bairro.isEmpty()) {
                    ""
                } else {
                    enderecoList[0].bairro
                },
                onValueChange = { letra ->
                    enderecoList[0].bairro = letra

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(5.dp, top = 20.dp),
                label = {
                    Text(text = "Bairro")
                },

                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            TextField(
                value = if (enderecoList[0].cidade.isEmpty()) {
                    ""
                } else {
                    enderecoList[0].cidade
                },
                onValueChange = { letra ->
                    enderecoList[0].cidade = letra

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(5.dp, top = 20.dp),
                label = {
                    Text(text = "Cidade")
                },

                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            TextField(
                value = if (enderecoList[0].uf.isEmpty()) {
                    ""
                } else {
                    enderecoList[0].uf
                },
                onValueChange = { letra ->
                    enderecoList[0].uf = letra

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(5.dp, top = 20.dp),
                label = {
                    Text(text = "Estado")
                },

                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            if (tipoOcorrencia == "violencia") TextField(
                value = agressor,
                onValueChange = { letra ->
                    agressor = letra

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(5.dp, top = 20.dp),
                label = {
                    Text(text = "Agressor / Membro Familiar")
                },

                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            if (tipoOcorrencia == "desaparecimento") TextField(
                value = desaparecido,
                onValueChange = { letra ->
                    desaparecido = letra

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(5.dp, top = 20.dp),
                label = {
                    Text(text = "Nome do desaparecido")
                },

                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            if (tipoOcorrencia == "roubo") TextField(
                value = roubo,
                onValueChange = { letra ->
                    roubo = letra

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(5.dp, top = 20.dp),
                label = {
                    Text(text = "Itens roubados")
                },

                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            if (tipoOcorrencia == "escolar") TextField(
                value = escola,
                onValueChange = { letra ->
                    escola = letra

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(5.dp, top = 20.dp),
                label = {
                    Text(text = "Nome da Escola")
                },

                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            Spacer(modifier = Modifier.height(25.dp))

            Column(
                verticalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.height(130.dp)
            ) {
                Button(
                    enabled = !(cep.isEmpty() && enderecoList[0].rua.isEmpty()
                            && numero.isEmpty() && enderecoList[0].bairro.isEmpty()
                            && enderecoList[0].cidade.isEmpty() && enderecoList[0].uf.isEmpty()
                            && (agressor.isEmpty() || roubo.isEmpty() || desaparecido.isEmpty() || escola.isEmpty())),
                    onClick = {
                        navController.navigate("ocorrenciaEnviada")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xC9F80505),
                        contentColor = Color(0xF3FDFFFF)
                    ),
                    shape = RectangleShape
                ) {
                    Text(text = "Enviar ocorrência", fontSize = 17.sp)
                }

                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xC9F80505),
                        contentColor = Color(0xF3FDFFFF)
                    ),
                    shape = RectangleShape
                ) {
                    Text(text = "Ligar para Policia (190)", fontSize = 17.sp)
                }
            }
        }
        // --- opçoes
        Spacer(modifier = Modifier.height(50.dp))

    }
}


