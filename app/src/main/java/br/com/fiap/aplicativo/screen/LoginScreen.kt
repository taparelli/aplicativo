package br.com.fiap.aplicativo.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.aplicativo.R
import br.com.fiap.aplicativo.ui.theme.AplicativoTheme

@Composable
fun LoginScreen(navController: NavController) {
    var texto by remember {
        mutableStateOf("")
    }
    var data by remember {
        mutableStateOf("")
    }
    var checkBox by remember {
        mutableStateOf("false")
    }


    //column principal
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.pm_logo),
            contentDescription = "logo policia militar",
            modifier = Modifier
                .size(250.dp)
                .padding(10.dp)
                .align(Alignment.CenterHorizontally)
        )

        //Campo login
        TextField(
            value = texto,
            onValueChange = { letra ->
                texto = letra

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)
                .align(Alignment.CenterHorizontally),
            label = {
                Text(text = "Login")
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Icone pessoa"
                )
            }

        )

        //Campo password
        TextField(
            value = data,
            onValueChange = { letra ->
                data = letra

            },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(top = 20.dp),
            label = {
                Text(text = "Password")
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "password"
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),

            //colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.Black)

        )

        //Checkbox lembrar login
        Row(verticalAlignment = Alignment.CenterVertically) {

            Checkbox(
                checked = checkBox.toBoolean(),
                onCheckedChange = { isSelected -> checkBox = isSelected.toString() },
                colors = CheckboxDefaults.colors(checkedColor = Color.Black)
            )
            Text(
                text = "Lembrar login",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White


            )
        }

        //Botão login
        Column() {
            Button(
                onClick = {

                    navController.navigate("sos")

                    navController.navigate("Menu")

                },
                modifier = Modifier
                    .offset(220.dp, 10.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF000000)),
                shape = RectangleShape
            )
            {
                Text(
                    text = "Login",
                    fontWeight = FontWeight.Bold
                )

                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Seta para login"
                )


            }

            Text(
                modifier = Modifier.padding(top = 10.dp),
                text = "Esqueci minha senha",
                fontSize = 13.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold

            )
            Text(
                modifier = Modifier.padding(top = 10.dp),
                text = "Não tem cadastro?",
                fontSize = 13.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold


            )

        }
        Spacer(modifier = Modifier.height(40.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { navController.navigate("sos") },
                modifier = Modifier.size(width = 200.dp, height = 50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xC9F80505),
                    contentColor = Color(0xF3FDFFFF)
                ),
                shape = RectangleShape

            ) {
                Text(
                    text = "SOS",
                    fontSize = 20.sp

                )
            }
        }

    }
}


//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun LoginPreview() {
//    AplicativoTheme {
//        LoginScreen(navController = )
//    }
