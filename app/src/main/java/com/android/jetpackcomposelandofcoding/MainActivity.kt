package com.android.jetpackcomposelandofcoding

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.android.jetpackcomposelandofcoding.ui.theme.JetpackComposeLandOfCodingTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val snackBarHost = remember {
                SnackbarHostState()
            }
            val scope = rememberCoroutineScope()
            var textFieldValue by remember {
                mutableStateOf("")
            }
            JetpackComposeLandOfCodingTheme{
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text("Scaffold")
                            },
                            modifier = Modifier.shadow(10.dp)
                        )
                    },
                    bottomBar = {
                            NavigationBar(containerColor = Color.Red) {
                                NavigationBarItem(
                                    selected = true,
                                    onClick = {},
                                    colors = NavigationBarItemDefaults.colors(Color.Transparent),
                                    icon = {
                                        Icon(
                                            imageVector = Icons.Default.Home,
                                            contentDescription = "null"
                                        )
                                    },
                                    label = {
                                        Text("Home")
                                    },
                                    alwaysShowLabel = true
                                )
                                NavigationBarItem(
                                    selected = true,
                                    onClick = {},
                                    colors = NavigationBarItemDefaults.colors(Color.Transparent),
                                    icon = {
                                        Icon(
                                            imageVector = Icons.Default.Favorite,
                                            contentDescription = "null"
                                        )
                                    },
                                    label = {
                                        Text("Favorite")
                                    },
                                    alwaysShowLabel = true
                                )
                                NavigationBarItem(
                                    selected = true,
                                    onClick = {},
                                    colors = NavigationBarItemDefaults.colors(Color.Transparent),
                                    icon = {
                                        Icon(
                                            imageVector = Icons.Default.AccountCircle,
                                            contentDescription = "null"
                                        )
                                    },
                                    label = {
                                        Text("Account")
                                    },
                                    alwaysShowLabel = true
                                )
                            }
                    },
                    snackbarHost = {
                        SnackbarHost(hostState = snackBarHost)
                    },
                    floatingActionButton = {
                        ExtendedFloatingActionButton(onClick = {
                            scope.launch {
                                snackBarHost.showSnackbar(textFieldValue)
                            }
                        }) {
                            Text("Show SnackBar")
                        }
                    }
                ) {
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .padding(top =it.calculateTopPadding() , bottom = it.calculateBottomPadding()),
                        contentAlignment = Alignment.Center){
                        TextField(value = textFieldValue, onValueChange = {textFieldValue = it})
                    }
                }
            }
        }
    }
}
