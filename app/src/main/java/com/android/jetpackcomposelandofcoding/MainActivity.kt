package com.android.jetpackcomposelandofcoding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.android.jetpackcomposelandofcoding.screens.Person
import com.android.jetpackcomposelandofcoding.screens.ScreenA
import com.android.jetpackcomposelandofcoding.screens.ScreenB
import com.android.jetpackcomposelandofcoding.screens.SharedViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "main") {
                navigation(
                    route = "main",
                    startDestination = "screenA"
                ) {
                    composable(
                        route = "screenA"
                    ) {
                        val viewModel: SharedViewModel =
                            it.SharedViewModel(navController = navController)
                        ScreenA(navigateToB = {
                            viewModel.person = it
                            navController.navigate("screenB")
                        })
                    }

                    composable(
                        route = "screenB"
                    ) {
                        val viewModel: SharedViewModel = it.SharedViewModel(navController)
                        viewModel.person?.let {
                            ScreenB(it)
                        }

                    }
                }

            }

        }
    }
}
