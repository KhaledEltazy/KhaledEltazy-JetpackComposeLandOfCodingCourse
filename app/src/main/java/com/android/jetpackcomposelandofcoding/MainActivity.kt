package com.android.jetpackcomposelandofcoding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
                        navController.navigate("screenB/$it")
                    })
                }

                composable(
                    route = "screenB/?text={text}&id={id}",
                    arguments = listOf(
                        navArgument("text"){
                            type = NavType.StringType
                            nullable = true
                        },
                        navArgument("id"){
                            type = NavType.IntType
                            defaultValue = 100
                        }
                    )
                ) {
                    it.arguments?.apply {
                        val text = getString("text") ?: ""
                        ScreenB(text)
                    }
                }
            }
        }
    }
}
