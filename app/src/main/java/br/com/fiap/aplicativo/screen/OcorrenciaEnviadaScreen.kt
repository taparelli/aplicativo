package br.com.fiap.aplicativo.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.aplicativo.R

@Composable
fun OcorrenciaEnviadaScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color(0xFF742222))
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.anuncio),
            contentDescription = "Pessoa com alto falante",
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = "Ocorrência Enviada!!",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.white)
            )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OcorrenciaEnviadaScreenPreview() {
    OcorrenciaEnviadaScreen()
}