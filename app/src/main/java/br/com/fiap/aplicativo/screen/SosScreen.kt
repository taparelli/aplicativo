package br.com.fiap.aplicativo.screen


import androidx.annotation.ColorRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.Button

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape

import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.aplicativo.R
import br.com.fiap.aplicativo.ui.theme.AplicativoTheme

@Composable
fun SosScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.Backgroud))
            .fillMaxSize(),

        ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.Backgroud))
        ) {
            // ---- header ---------
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .background(colorResource(id = R.color.menu))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.anuncio),
                    contentDescription = "Pessoa com alto falante",
                    modifier = Modifier
                        .size(80.dp)
                        .padding(10.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "Registrar ocorrência",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    )
            }
            // --- opçoes
            Spacer(modifier = Modifier.height(50.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {


                Button(
                    onClick = {navController.navigate("ocorrencia/violencia")},
                    modifier = Modifier
                        .height(150.dp)
                        .width(150.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xC9FFFFFF)
                    ),
                    shape = RoundedCornerShape(16.dp),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 10.dp
                    )
                ) {
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.violencia),
                            contentDescription = "Violencia familiar",
                            modifier = Modifier
                                .size(90.dp)
                        )
                        Text(
                            text = "Violência familiar",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = Color.Black,
                        )
                    }
                }

                Button(
                    onClick = {navController.navigate("ocorrencia/desaparecimento")},
                    modifier = Modifier
                        .height(150.dp)
                        .width(150.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xC9FFFFFF)
                    ),
                    shape = RoundedCornerShape(16.dp),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 10.dp)
                ) {
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.desaparecer),
                            contentDescription = "Perturbação do sossego",
                            modifier = Modifier
                                .size(90.dp)
                        )
                        Text(
                            text = "Desaparecimento",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = Color.Black,
                            )
                    }
                }

            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {

                Button(
                    onClick = {navController.navigate("ocorrencia/roubo")},
                    modifier = Modifier
                        .height(150.dp)
                        .width(150.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xC9FFFFFF)
                    ),
                    shape = RoundedCornerShape(16.dp),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 10.dp
                    )
                ) {
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.bandido),
                            contentDescription = "Bandico",
                            modifier = Modifier
                                .size(90.dp)
                        )
                        Text(
                            text = "Furto/Roubo",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = Color.Black,
                            )
                    }
                }




                Button(
                    onClick = {navController.navigate("ocorrencia/escolar")},
                    modifier = Modifier
                        .height(150.dp)
                        .width(150.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xC9FFFFFF)
                    ),
                    shape = RoundedCornerShape(16.dp),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 10.dp
                    )
                ) {
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.escola),
                            contentDescription = "Segurança Escolar",
                            modifier = Modifier
                                .size(90.dp)
                        )
                        Text(
                            text = "Segurança escolar",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = Color.Black,
                            )
                    }
                }
            }
            Spacer(modifier = Modifier.height(80.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {

                Button(
                    onClick = { navController.navigate("Login")},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xC9F80505),
                        contentColor =  Color(0xF3FDFFFF)),
                    shape = RectangleShape
                ) {
                    Text(text = "Voltar")
                }

            }
        }
    }
}

////@Preview(showBackground = true, showSystemUi = true)
////@Composable
////fun SosPreview() {
////    AplicativoTheme {
////        SosScreen()
//    }
//}