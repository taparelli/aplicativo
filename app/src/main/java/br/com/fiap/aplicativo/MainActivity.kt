package br.com.fiap.aplicativo

import android.graphics.Color.rgb
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.aplicativo.screen.LoginScreen
import br.com.fiap.aplicativo.screen.MenuScreen
import br.com.fiap.aplicativo.screen.OcorrenciaEnviadaScreen
import br.com.fiap.aplicativo.screen.OcorrenciaScreen

import br.com.fiap.aplicativo.screen.SosScreen
import br.com.fiap.aplicativo.ui.theme.AplicativoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AplicativoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(rgb(129, 130, 133))
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "Menu"){

                        composable(route = "Menu"){
                            MenuScreen(navController)
                        }

                        composable(route = "Login"){
                            LoginScreen(navController)
                        }
                        composable(route = "sos"){
                            SosScreen(navController)
                        }

                        composable(route="ocorrencia/{tipoOcorrencia}"){
                            val tipoOcorrencia = it.arguments?.getString("tipoOcorrencia")
                            OcorrenciaScreen(navController,tipoOcorrencia!!)
                        }
                        composable(route="ocorrenciaEnviada"){
                            OcorrenciaEnviadaScreen()
                        }

                    }
                }
            }
        }
    }
}






