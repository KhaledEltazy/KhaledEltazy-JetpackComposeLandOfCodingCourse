package com.android.jetpackcomposelandofcoding.side_effect

import android.app.Activity
import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SystemBarColorChanger(
    statusBarColor : Color?,
    navigationBarColor : Color?
){
    val activity = LocalView.current.context as? Activity
    val window = activity?.window

    SideEffect {
        statusBarColor?.let {
            window!!.statusBarColor = it.toArgb()
        }
        navigationBarColor?.let {
            window!!.navigationBarColor = it.toArgb()
        }
    }
}