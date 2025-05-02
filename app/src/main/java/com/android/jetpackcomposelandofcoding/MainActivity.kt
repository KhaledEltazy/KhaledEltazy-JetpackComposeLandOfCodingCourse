package com.android.jetpackcomposelandofcoding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.jetpackcomposelandofcoding.screens.ScreenA
import com.android.jetpackcomposelandofcoding.screens.ScreenB
import com.android.jetpackcomposelandofcoding.screens.ScreenC

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "screen_a"){
                composable(
                    route = "screen_a"
                ){
                    ScreenA(navigateToB = {
                        navController.navigate("screen_b")
                    })
                }

                composable(
                    route = "screen_b"
                ){
                    ScreenB(
                        navigateToC = {
                            navController.navigate("screen_c")
                        },
                        navigateBack = {
                            navController.popBackStack()
                        }
                    )
                }

                composable(
                    route = "screen_c"
                ){
                    ScreenC(
                        navigateBackToB = {
                            navController.popBackStack()
                        },
                        navigateBackToA = {
//                            navController.popBackStack()
//                            navController.popBackStack()
                            navController.navigate("screen_a"){
                                popUpTo(0)
                            }
                        }
                    )
                }
            }
        }
    }
}
