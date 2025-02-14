package com.example.retrofitcomposeproje

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.retrofitcomposeproje.model.User
import com.example.retrofitcomposeproje.screens.detayScreen
import com.example.retrofitcomposeproje.screens.userList
import com.example.retrofitcomposeproje.ui.theme.RetrofitComposeProjeTheme
import com.example.retrofitcomposeproje.viewmodel.UserViewModel
import com.google.gson.Gson

class MainActivity : ComponentActivity() {

    private val viewModel: UserViewModel by viewModels<UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController: NavHostController = rememberNavController()

            RetrofitComposeProjeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        NavHost(navController = navController, startDestination = "liste_ekrani") {
                            composable("liste_ekrani") {
                                viewModel.fetchData()
                                userList(userList = viewModel.userData.value, navController)
                            }
                            composable(
                                "detay_ekrani/{secilenKullanici}", arguments = listOf(
                                    navArgument("secilenKullanici") {
                                        type = NavType.StringType
                                    }
                                )
                            ) {
                                val kullaniciString = remember {
                                    it.arguments?.getString("secilenKullanici")
                                }
                                val secilenKullanici =
                                    Gson().fromJson(kullaniciString, User::class.java)
                                detayScreen(secilenKullanici)
                            }
                        }


                    }
                }
            }
        }
    }
}
