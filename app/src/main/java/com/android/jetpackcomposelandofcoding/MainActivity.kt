package com.android.jetpackcomposelandofcoding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.android.jetpackcomposelandofcoding.screens.Person
import com.android.jetpackcomposelandofcoding.screens.ScreenA
import com.android.jetpackcomposelandofcoding.screens.ScreenB

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "screenA"){
                composable(
                    route = "screenA"
                ) {
                    ScreenA(navigateToB = {
                        navController.currentBackStackEntry?.savedStateHandle?.set(
                            "person",it
                        )
                        navController.navigate("screenB")
                    })
                }

                composable(
                    route = "screenB"
                ) {
                    navController.previousBackStackEntry?.savedStateHandle?.get<Person>("person")?.let {
                        ScreenB(it)
                    }                }

            }
        }
    }
}
